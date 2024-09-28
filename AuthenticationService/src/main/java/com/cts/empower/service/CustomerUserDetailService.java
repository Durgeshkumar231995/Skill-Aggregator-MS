package com.cts.empower.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.hc.client5.http.auth.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cts.empower.Entity.UserDetailsInfo;
import com.cts.empower.dto.AuthenticationRequest;
import com.cts.empower.repository.UserDetailsRepository;
import com.cts.empower.util.JwtUtil;
@Component
public class CustomerUserDetailService {

	@Autowired
	private UserDetailsRepository userRepository;

	@Autowired
	private JwtUtil jwtUtil;

	public Map<String,String> login(AuthenticationRequest authRequest) throws InvalidCredentialsException
	{
		Map<String, String> token = new HashMap<String, String>();

UserDetailsInfo  userDetail=userRepository.findByEmailAndPassword(authRequest.getEmail(),authRequest.getPassword());
		if (userDetail == null) {
throw new InvalidCredentialsException("Invalid Email or Password");
		}
		token=jwtUtil.generateToken(userDetail.getEmail());

		return token;
	}

	

}
