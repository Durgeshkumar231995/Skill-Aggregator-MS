package com.cts.empower.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FavouriteRequest {
	private String email;
	@Id
	private String id;
		private String gender;
		@JsonProperty("Experience (Years)")
		private int experience_years;
		private String position;
		private String salary;
}
