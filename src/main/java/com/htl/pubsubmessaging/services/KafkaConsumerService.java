package com.htl.pubsubmessaging.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

	private final Logger logger = LoggerFactory.getLogger(KafkaConsumerService.class);
	
	@KafkaListener(topics="${general.topic.name}",groupId="${general.group.id}")
	public void generalConsume(String generalMessage) {
		logger.info(String.format("Message received :: %s", generalMessage));
	}
	
	@KafkaListener(topics="${user.topic.name}",groupId="${user.group.id}")
	public void userConsume(String userMessage) {
		logger.info(String.format("Message received :: %s", userMessage));
	}
}
