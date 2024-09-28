package com.cts.empower.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	@ExceptionHandler(SkillIdIsNotPresentException.class)
	public ResponseEntity<String> handleSkillIdIsNotPresentException(SkillIdIsNotPresentException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}
	@ExceptionHandler(SkillPositionIsNotPresentException.class)
	public ResponseEntity<String> handleSkillPositionIsNotPresentException(SkillPositionIsNotPresentException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}
	@ExceptionHandler(SkillSalaryIsNotPresentException.class)
	public ResponseEntity<String> handleSkillSalaryIsNotPresentException(SkillSalaryIsNotPresentException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}
	@ExceptionHandler(SkillExperienceIsNotPresentException.class)
	public ResponseEntity<String> handleSkillExperienceIsNotPresentException(SkillExperienceIsNotPresentException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
	}

}
