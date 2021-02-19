package com.htl.pubsubmessaging.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.htl.pubsubmessaging.services.ProducerService;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

	private final ProducerService producerService;
	
	@Autowired
	public KafkaController(ProducerService producerService) {
		this.producerService = producerService;
	}
	
	@RequestMapping(value="/publish", method=RequestMethod.POST)
	public void sendMessage(@RequestParam String message) {
		producerService.sendMessage(message);
	}
	
}
