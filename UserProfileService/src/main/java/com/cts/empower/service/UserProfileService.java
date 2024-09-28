package com.cts.empower.service;

import com.cts.empower.dto.UserProfileRequest;
import com.cts.empower.dto.UserProfileResponse;


public interface UserProfileService {

	public UserProfileResponse registerUser(UserProfileRequest profileRequest);
	public UserProfileResponse updateProfile(String email,UserProfileRequest profileRequest);
	public UserProfileResponse getProfileByEmail(String email);
	public String changepasswordByUserId(Long userId, String password);
}
