package com.cts.empower.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class SkillDataResponse {

    private String id;
	private String gender;
	@JsonProperty("Experience (Years)")
	private int experience_years;
	private String position;
	private String salary;
}
