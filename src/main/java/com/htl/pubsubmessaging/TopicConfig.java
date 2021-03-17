package com.htl.pubsubmessaging;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class TopicConfig {

	@Value(value="${kafka.bootstrapAddress}")
	private String bootstrapAddress;
	
	@Value(value="${general.topic.name}")
	private String generalTopicName;
	
	@Value(value="${user.topic.name}")
	private String userTopicName;
	
	//Spring Kafka will automatically add topics for all beans of type NewTopic
	@Bean
	public NewTopic generalTopic() {
		return TopicBuilder.name(generalTopicName).partitions(1).replicas(1).build();
	}
	
	@Bean
	public NewTopic userTopic() {
		return TopicBuilder.name(generalTopicName).partitions(1).replicas(1).build();
	}
	
	// If not using Spring boot, this kafkaAdmin has to be created
	/*@Bean
	public KafkaAdmin kafkaAdmin() {
		Map<String, Object> configs = new HashMap<>();
		configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
		return KafkaAdmin(configs);
	}*/
	
}
