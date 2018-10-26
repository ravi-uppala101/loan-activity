FROM confluentinc/ksql-clickstream-demo:5.0.0


WORKDIR /app
RUN mkdir -p data/input
RUN chmod 777 data/input/
COPY loan-activity-0.0.1-SNAPSHOT.jar .