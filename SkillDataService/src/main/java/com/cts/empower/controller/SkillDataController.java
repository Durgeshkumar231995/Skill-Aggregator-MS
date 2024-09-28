package com.cts.empower.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.empower.dto.FavouriteRequest;
import com.cts.empower.dto.FavouriteResponse;
import com.cts.empower.dto.SkillDataResponse;
import com.cts.empower.feign.FavouriteClient;
import com.cts.empower.service.SkillDataServiceImpl;

@RestController
@RequestMapping("/api/v1/skillset")
public class SkillDataController {

	@Autowired
	SkillDataServiceImpl skillDataService;
	@Autowired
	FavouriteClient client;

	@PostMapping("/addfavourite/{email}")
	public FavouriteResponse createFavourite(@PathVariable String email, @RequestBody FavouriteRequest request) {
		System.out.println("=====================fsffs");
		return client.favouriteSkill(email, request);

	}

	@GetMapping("/getAllRoles")
	public ResponseEntity<SkillDataResponse[]> getAllRoles() {
		return ResponseEntity.status(HttpStatus.OK).body(skillDataService.getallRoles());
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Optional<SkillDataResponse>> getById(@PathVariable String id) {
		return ResponseEntity.status(HttpStatus.OK).body(skillDataService.getById(id));
	}

	@GetMapping("/getByPosition/{position}")
	public ResponseEntity<List<SkillDataResponse>> getByPosition(@PathVariable String position) {
		return ResponseEntity.status(HttpStatus.OK).body(skillDataService.getByPosition(position));
	}

	@GetMapping("/getBySalary/{salary}")
	public ResponseEntity<List<SkillDataResponse>> getBySalary(@PathVariable String salary) {
		return ResponseEntity.status(HttpStatus.OK).body(skillDataService.getBySalary(salary));
	}

	@GetMapping("/getByExperienceyears/{experience_years}")
	public ResponseEntity<List<SkillDataResponse>> getByExperienceyears(@PathVariable int experience_years) {
		return ResponseEntity.status(HttpStatus.OK).body(skillDataService.getByExperienceyears(experience_years));
	}

}
