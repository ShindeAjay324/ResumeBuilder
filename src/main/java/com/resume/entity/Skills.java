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
import javax.persistence.OneToOne;
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
@Table(name = "skills")
public class Skills {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_skill")
	private Integer skillId;
	
	@CollectionTable(name = "skill_fronted_tech", joinColumns = @JoinColumn(name = "id_skill")) 
	@ElementCollection
	private List<String> frontedTech;
	
	@CollectionTable(name = "skill_backend_tech", joinColumns = @JoinColumn(name = "id_skill")) 
	@ElementCollection
	private List<String> backendTech;
	
	@CollectionTable(name = "skill_middleware_tech", joinColumns = @JoinColumn(name = "id_skill")) 
	@ElementCollection
	private List<String> middlewareTech;
	
	@CollectionTable(name = "skill_design_pattern", joinColumns = @JoinColumn(name = "id_skill")) 
	@ElementCollection
	private List<String> designPattern;
	
	@CollectionTable(name = "skill_databases", joinColumns = @JoinColumn(name = "id_skill")) 
	@ElementCollection
	private List<String> skillDatabases;
	
	@CollectionTable(name = "skill_version_control", joinColumns = @JoinColumn(name = "id_skill")) 
	@ElementCollection
	private List<String> versionControlSystem;
	
	@CollectionTable(name = "skill_aws", joinColumns = @JoinColumn(name = "id_skill")) 
	@ElementCollection
	private List<String> aws;
	
	@CollectionTable(name = "skill_development_tools", joinColumns = @JoinColumn(name = "id_skill")) 
	@ElementCollection
	private List<String> developmentTools;
	
	@OneToOne(mappedBy = "skills")
	@JsonBackReference
	private Profile profile;
	

}
