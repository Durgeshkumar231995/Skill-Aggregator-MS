package com.cts.empower.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.empower.dto.AuthenticationRequest;
import com.cts.empower.dto.AuthenticationResponse;
import com.cts.empower.service.CustomerUserDetailService;
import com.cts.empower.util.JwtUtil;

import jakarta.ws.rs.BadRequestException;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
	/*
	 * @Autowired private AuthenticationManager authenticationManager;
	 */
	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private CustomerUserDetailService userDetailsService;

	@PostMapping("/authenticate/login")
	public ResponseEntity<?> login(@RequestBody AuthenticationRequest authRequest) {
	  
			try {
	    	return new ResponseEntity<>(userDetailsService.login(authRequest), HttpStatus.OK);
			}
			catch (Exception e) {
				// TODO: handle exception
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
			}

	   // return ResponseEntity.ok(new AuthenticationResponse(token));
    }
	/*    catch(BadCredentialsException e)
	{
//		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
	}
//	    catch(Exception e)
	{
//		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
	}*/
	

}
