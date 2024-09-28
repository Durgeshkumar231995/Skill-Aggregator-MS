package com.cts.empower.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cts.empower.Entity.UserDetailsInfo;
import com.cts.empower.dto.UserProfileRequest;
import com.cts.empower.repository.UserDetailsRepository;

@Service
public class KafkaService {
	@Autowired
	private UserDetailsRepository userRepository;

	/*
	 * @Autowired private PasswordEncoder passwordEncoder;
	 */
	  @KafkaListener(topics = "registationdetail", groupId =
	  "authentication-service-group") public void
	  consumeRegistration(UserProfileRequest userProfileRequest) {
	  
	  UserDetailsInfo user = new UserDetailsInfo();
	  user.setId(userProfileRequest.getUserId());
	  user.setEmail(userProfileRequest.getEmail());
	//  user.setPassword(passwordEncoder.encode(userProfileRequest.getPassword()));
	  user.setPassword(userProfileRequest.getPassword());
	  System.out.println(
	  "====value======================="+user);
	  
	  userRepository.save(user); }
	 
}
