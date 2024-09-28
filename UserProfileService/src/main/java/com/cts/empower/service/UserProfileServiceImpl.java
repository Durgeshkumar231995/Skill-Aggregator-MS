package com.cts.empower.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.empower.dto.UserProfileRequest;
import com.cts.empower.dto.UserProfileResponse;
import com.cts.empower.entity.UserProfile;
import com.cts.empower.globalException.EmailAlreadyInUseException;
import com.cts.empower.globalException.PasswordMismatchException;
import com.cts.empower.globalException.UserDoesNotExistException;
import com.cts.empower.repository.UserProfileRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
@Transactional
@Service
public class UserProfileServiceImpl implements UserProfileService {
	@Autowired
	private UserProfileRepository userprofileRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserProfileResponse registerUser(UserProfileRequest profileRequest) {
		// TODO Auto-generated method stub
		UserProfile userProfile = modelMapper.map(profileRequest, UserProfile.class);
		Optional<UserProfile> userProfileEmail = userprofileRepository.findByEmail(profileRequest.getEmail());
		if (userProfileEmail.isPresent()) {
			throw new EmailAlreadyInUseException("Email is already in use");
		}
		if (!profileRequest.getConfirmPassword().equals(profileRequest.getPassword())) {
			throw new PasswordMismatchException("Password mismatch");
		}

		UserProfile registeredUser = userprofileRepository.save(userProfile);
		UserProfileResponse userProfileResponse = modelMapper.map(registeredUser, UserProfileResponse.class);
		return userProfileResponse;

	}

	public UserProfileResponse updateProfile(String email,UserProfileRequest profileRequest) {
		// TODO Auto-generated method stub
		UserProfile userProfile = modelMapper.map(profileRequest, UserProfile.class);
		Optional<UserProfile> getUserProfile = userprofileRepository.findByEmail(email);
		UserProfile existingProfile;
		UserProfile updatedUserProfile;
		if (getUserProfile.isPresent()) {
			existingProfile = getUserProfile.get();
			existingProfile.setFirstName(userProfile.getFirstName());
			existingProfile.setLastName(userProfile.getLastName());
			//existingProfile.setEmail(userProfile.getEmail());
			existingProfile.setDateOfBirth(userProfile.getDateOfBirth());
			existingProfile.setCountry(userProfile.getCountry());
			existingProfile.setMobileNumber(userProfile.getMobileNumber());
			userprofileRepository.save(existingProfile);
			updatedUserProfile = userprofileRepository.findById(existingProfile.getUserId())
					.orElseThrow(() -> new UserDoesNotExistException("User does not exist"));

		} else {
			throw new UserDoesNotExistException("User does not exist");
		}
		UserProfileResponse updatedProfile = modelMapper.map(updatedUserProfile, UserProfileResponse.class);

		return updatedProfile;
	}

	public UserProfileResponse getProfileByEmail(String email) {
		// TODO Auto-generated method stub
		Optional<UserProfile> getuserProfile = userprofileRepository.findByEmail(email);
		if (getuserProfile.isEmpty()) {
			throw new UserDoesNotExistException("User does not exist");
		}
		UserProfileResponse getProfile = modelMapper.map(getuserProfile.get(), UserProfileResponse.class);

		return getProfile;

	}

	public String changepasswordByUserId(Long userId, String password) {
		// TODO Auto-generated method stub
		return userprofileRepository.findById(userId).map(userProfile -> {
			userProfile.setPassword(password);
			userProfile.setConfirmPassword(password);
			userprofileRepository.save(userProfile);
			return "Password changed successfully";
		}).orElseThrow(() -> new UserDoesNotExistException("User not found"));
	}

}
