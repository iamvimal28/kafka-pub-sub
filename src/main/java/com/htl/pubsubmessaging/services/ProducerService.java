package com.htl.pubsubmessaging.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService {

	private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);
	
	private final String TOPIC = "kafkatopic";
	
	private final KafkaTemplate<String,String> kafkaTemplate;

	@Autowired
	public ProducerService(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void sendMessage(String message) {
		logger.info(String.format("Producing message: %s", message));
		/*
		 * Usually for fast stream processing this is enough
		 */
		this.kafkaTemplate.send(TOPIC,message);
		/*
		 * This is to wait for result so it blocks the thread to wait for result
		 */
//		ListenableFuture<SendResult<String, String>> future = this.kafkaTemplate.send(TOPIC,message);
//		future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
//
//			@Override
//			public void onSuccess(SendResult<String, String> result) {
//				logger.info("Sent message=[ {} ] with offset=[ {} ]", message, result.getRecordMetadata().offset());
//			}
//
//			@Override
//			public void onFailure(Throwable ex) {
//				logger.info("Unable to send message=[ {} ] due to : {}", message, ex.getMessage());	
//			}
//			
//		});
	}
	
	
	
	
}
