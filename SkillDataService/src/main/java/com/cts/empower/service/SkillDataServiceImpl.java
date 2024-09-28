package com.cts.empower.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.empower.dto.SkillDataResponse;
import com.cts.empower.exception.SkillExperienceIsNotPresentException;
import com.cts.empower.exception.SkillIdIsNotPresentException;
import com.cts.empower.exception.SkillPositionIsNotPresentException;
import com.cts.empower.exception.SkillSalaryIsNotPresentException;

@Service
public class SkillDataServiceImpl implements SkillDataService {
	@Autowired
	private RestTemplate restTemplate;

	public SkillDataResponse[] accessingRoleApi() {
		String url = "http://localhost:3030/roles";
		SkillDataResponse[] dataResponse = restTemplate.getForObject(url, SkillDataResponse[].class);
		return dataResponse;
	}

	@Override
	public SkillDataResponse[] getallRoles() {
		// TODO Auto-generated method stub
		return accessingRoleApi();
	}

	public Optional<SkillDataResponse> getById(String id) {
		Optional<SkillDataResponse> skillById= Arrays.stream(accessingRoleApi()).filter(a->a.getId().equals(id)).findFirst();
		if(skillById.isEmpty()) {
		throw new SkillIdIsNotPresentException("Skill Id Is Not Present");	

	}
	else
	{
		return skillById;		}
	}
	public List<SkillDataResponse> getByPosition(String position) {
		// TODO Auto-generated method stub
		List<SkillDataResponse> getByPosition=  Arrays.stream(accessingRoleApi()).filter(a->a.getPosition().equals(position)).collect(Collectors.toList());
		if(getByPosition.isEmpty()) {
			throw new SkillPositionIsNotPresentException("Position Is Not Present");		
		}
		return getByPosition;
	}

	public List<SkillDataResponse> getBySalary(String salary) {
		// TODO Auto-generated method stub
		List<SkillDataResponse>  getBySalary=Arrays.stream(accessingRoleApi()).filter(a->a.getSalary().equals(salary)).collect(Collectors.toList());
		if(getBySalary.isEmpty()) {
			throw new SkillSalaryIsNotPresentException("Salary Is Not Present");		
		}
		return getBySalary;
	}
	public List<SkillDataResponse> getByExperienceyears(int experience_years) {
		// TODO Auto-generated method stub
		List<SkillDataResponse>  getByExperienceyears=Arrays.stream(accessingRoleApi()).filter(a->a.getExperience_years()==experience_years).collect(Collectors.toList());
		if(getByExperienceyears.isEmpty()) {
			throw new SkillExperienceIsNotPresentException("Experience Year Is Not Present");		
		}
		return getByExperienceyears;
	}

	

}
