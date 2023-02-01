package com.resume.dto;

import java.util.List;

import com.resume.entity.AchievementDetails;
import com.resume.entity.EducationDetails;
import com.resume.entity.ProjectDetails;
import com.resume.entity.Skills;
import com.resume.entity.Summary;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class ProfileDto {
	private String firstName;
	private String lastName;
	private List<String> technology;
	private String totalExperience;
	private String relevantExperience;
	private List<EducationDetailsDto> details;
	private SkillsDto skills;
	private AchievementDetailsDto achievementDetails;
	private List<ProjectDetailsDto> projectDetails;
	private List<SummaryDto> summary;
	
}
