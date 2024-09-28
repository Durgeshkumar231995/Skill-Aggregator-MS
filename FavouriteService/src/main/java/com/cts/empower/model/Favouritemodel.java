package com.cts.empower.model;

import com.cts.empower.dto.FavouriteRequest;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "favouritemodel")
public class Favouritemodel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long FavouriteId;
	private String id;
	private String email;
	private String gender;
	@JsonProperty("Experience (Years)")
	private int experience_years;
	private String position;
	private String salary;
}
