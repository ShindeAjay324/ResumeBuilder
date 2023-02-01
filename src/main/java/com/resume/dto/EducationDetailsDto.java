package com.resume.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EducationDetailsDto {
	private String education;
	private String specilization;
	private String university;
	private Integer passOutYear;
	private Double percentage;
}
