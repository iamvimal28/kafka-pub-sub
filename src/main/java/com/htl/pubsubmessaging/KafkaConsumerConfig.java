package com.htl.pubsubmessaging;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.htl.pubsubmessaging.models.User;

@Configuration
public class KafkaConsumerConfig {

	@Value(value="${kafka.bootstrapAddress}")
	private String bootstrapAddress;
	
	@Value(value="${general.topic.group.id}")
	private String generalGroupId;
	
	@Value(value="${user.topic.group.id}")
	private String userGroupId;
	
	// To consume general messages fro kafka
	@Bean
	public ConsumerFactory<String,String> generalConsumerFactory(){
		Map<String,Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, generalGroupId);
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
		return new DefaultKafkaConsumerFactory<>(props);
		
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String,String> generalKafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String,String> factory = 
				new ConcurrentKafkaListenerContainerFactory<String,String>();
		factory.setConsumerFactory(generalConsumerFactory());
		return factory;
	}
	
	// To consume user messages
	@Bean
	public ConsumerFactory<String,User> userConsumerFactory(){
		Map<String,Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, userGroupId);
		props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
		return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(User.class));
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String,User> userKafkaListenerContainerFactory(){
		ConcurrentKafkaListenerContainerFactory<String,User> factory = 
				new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(userConsumerFactory());
		return factory;
	} 
}
