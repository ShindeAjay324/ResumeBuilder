package com.resume.entity;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "project_details")
public class ProjectDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "project_id")
	private Integer projectId;
	
	@NotNull
	@CollectionTable(name = "project_technology", joinColumns = @JoinColumn(name = "project_id")) 
	@ElementCollection
	private List<String> projectFrontendtech;
	
	@NotNull
	@CollectionTable(name = "project_backend_tech", joinColumns = @JoinColumn(name = "project_id")) 
	@ElementCollection
	private List<String> projectbackendtech;
	
	@NotNull
	@CollectionTable(name = "project_builder_pattern", joinColumns = @JoinColumn(name = "project_id")) 
	@ElementCollection
	private List<String> projectBuilderPattern;
	
	@NotNull
	@CollectionTable(name = "project_database", joinColumns = @JoinColumn(name = "project_id")) 
	@ElementCollection
	private List<String> projectDatabases;
	
	@NotNull
	@CollectionTable(name = "project_development_tools", joinColumns = @JoinColumn(name = "project_id")) 
	@ElementCollection
	private List<String> projectDevlopmentTools;
	
	@Column(name = "project_duration",nullable = false)
	private String projectDuration;
	
	@Column(name = "project_team_size",nullable = false)
	private Integer projectTeamSize;
	
	@Column(name = "project_description",nullable = false)
	private String projectDescription;
	
	@Column(name = "project_roles_responsibilities",nullable = false)
	private String projectRolesAndResponsibilities;
	
	@ManyToOne
	@JsonBackReference
	private Profile profile;

}
