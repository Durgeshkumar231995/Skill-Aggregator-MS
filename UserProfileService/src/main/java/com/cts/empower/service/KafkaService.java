package com.cts.empower.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.cts.empower.dto.UserProfileRequest;


@Service
public class KafkaService {
	 @Autowired
	    private KafkaTemplate<String, Object> kafkaTemplate;


	    public void sendRegistrationEvent(UserProfileRequest profileRequest) {
	    	System.out.println(profileRequest+"===================");
	        kafkaTemplate.send("registationdetail", profileRequest);
	    }
}
