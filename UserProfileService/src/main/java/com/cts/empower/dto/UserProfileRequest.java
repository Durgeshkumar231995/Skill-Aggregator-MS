package com.cts.empower.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
public class UserProfileRequest {
	
	//private Long userId;
	@NotNull
	@NotEmpty(message = "FirstName is required")
	private String firstName;
	@NotNull
	@NotEmpty(message = "Lastname is required")
	private String lastName;
	@NotNull
	@NotEmpty(message = "Email is required")
	@Email(message = "Email should be valid")
	private String email;
	@NotEmpty(message = "Password is required")
	@NotNull
	private String password;
	@NotEmpty(message = "confirm Password is required")
	@NotNull
	private String confirmPassword;
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dateOfBirth;
	@NotEmpty(message = "Mobile Number should be 10 digit")
	@NotNull
	@Pattern(regexp="^[0-9]{10}$")
	private String mobileNumber;
	@NotNull
	@NotEmpty(message = "Country is required")
	private String country;
	 public UserProfileRequest() {}
	
}
