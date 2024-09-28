package com.cts.empower.service;


import java.util.List;
import java.util.Optional;

import com.cts.empower.dto.SkillDataResponse;

public interface SkillDataService {
	public SkillDataResponse[] getallRoles();
	public Optional<SkillDataResponse> getById(String id);
	public List<SkillDataResponse> getByPosition(String position);
	public List<SkillDataResponse> getBySalary(String salary);
	public List<SkillDataResponse> getByExperienceyears(int experience_years);
}
