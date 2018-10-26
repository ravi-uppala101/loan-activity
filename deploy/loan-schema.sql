-- lets the windows accumulate more data
set 'commit.interval.ms'='2000';
set 'cache.max.bytes.buffering'='10000000';
set 'auto.offset.reset'='earliest';

-- 1. SOURCE of ClickStream
DROP STREAM IF EXISTS loanstream;

CREATE STREAM loanstream (id bigint, manufacturer varchar, make varchar) with (kafka_topic = 'loantopic', value_format = 'json');

----------------------------------------------------------------------------------------------------------------------------
-- A series of basic loan data-analytics
--
-- Min, Max, UDFs etc
----------------------------------------------------------------------------------------------------------------------------

 -- number of events per minute - think about key-for-distribution-purpose - shuffling etc - shouldnt use 'userid'
DROP TABLE IF EXISTS events_per_min;
CREATE table events_per_min AS SELECT id, count(*) AS events FROM loanstream window TUMBLING (size 60 second) GROUP BY make;
