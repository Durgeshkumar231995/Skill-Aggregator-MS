package com.cts.empower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.empower.dto.UserProfileRequest;
import com.cts.empower.dto.UserProfileResponse;
import com.cts.empower.service.KafkaService;
import com.cts.empower.service.UserProfileServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/userprofile")
public class UserProfileRegistrationController {
	@Autowired
	private KafkaService kafkaService;

	@Autowired
	private UserProfileServiceImpl userProfileService;

	@PostMapping("/register")
	public ResponseEntity<UserProfileResponse> userRegistration(@RequestBody @Valid UserProfileRequest profileRequest) {
		kafkaService.sendRegistrationEvent(profileRequest);
		UserProfileResponse profileResponse = userProfileService.registerUser(profileRequest);
		return ResponseEntity.status(HttpStatus.CREATED).body(profileResponse);

	}

	@PutMapping("/updateProfile/{email}")
	public ResponseEntity<UserProfileResponse> updateProfile(@PathVariable String email,@RequestBody UserProfileRequest profileRequest) {
		UserProfileResponse profileResponse = userProfileService.updateProfile(email,profileRequest);
		return ResponseEntity.status(HttpStatus.OK).body(profileResponse);

	}

	@GetMapping("/getUserByEmail/{email}")
	public ResponseEntity<UserProfileResponse> getProfileByEmail(@PathVariable String email) {
		UserProfileResponse profileResponse = userProfileService.getProfileByEmail(email);
		return ResponseEntity.status(HttpStatus.OK).body(profileResponse);

	}

	/*@PatchMapping("/changepasswordByUserId/{userId}/{password}")
	public ResponseEntity<String> changePassword(@PathVariable Long userId, @PathVariable String password) {
		String profileResponse = userProfileService.changepasswordByUserId(userId, password);
		return ResponseEntity.status(HttpStatus.OK).body(profileResponse);

	}*/
	
	

}
