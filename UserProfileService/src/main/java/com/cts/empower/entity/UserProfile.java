package com.cts.empower.entity;

import java.time.LocalDate;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserProfile {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long userId;
private String firstName;
private String lastName;
private String email;
private String confirmPassword;
private String password;
private LocalDate dateOfBirth;
private String mobileNumber;
private String country;

}
