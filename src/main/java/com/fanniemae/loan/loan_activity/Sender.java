package com.fanniemae.loan.loan_activity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class Sender {

	private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);
	
	@Autowired
	private KafkaTemplate<String, Lar96Record> kafkaTemplate;
	
	public Sender(KafkaTemplate<String, Lar96Record> kafkaTemplate){
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void send(String topic, String key, Lar96Record loanRecord) {
		//LOGGER.info("sending payload='{}' to topic='{}'", loanRecord, topic);
		kafkaTemplate.send(topic, key, loanRecord);
	}
}
