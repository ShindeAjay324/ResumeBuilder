package com.resume.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class ProjectDetailsDto {
	private List<String> projectFrontendtech;
	private List<String> projectbackendtech;
	private List<String> projectBuilderPattern;
	private List<String> projectDatabases;
	private List<String> projectDevlopmentTools;
	private String projectDuration;
	private Integer projectTeamSize;
	private String projectDescription;
	private String projectRolesAndResponsibilities;
	
}
