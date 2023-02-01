package com.resume.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class SkillsDto {
	private List<String> frontedTech;
	private List<String> backendTech;
	private List<String> middlewareTech;
	private List<String> designPattern;
	private List<String> skillDatabases;
	private List<String> versionControlSystem;
	private List<String> aws;
	private List<String> developmentTools;
}
