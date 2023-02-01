package com.resume.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "profile")
public class Profile {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "profile_id")
	private Integer userID;
	
	@Column(name = "first_name",nullable = false)
	private String firstName;
	
	@Column(name = "last_name",nullable = false)
	private String lastName;
	
	@ElementCollection
	@CollectionTable(name = "profile_technology", joinColumns = @JoinColumn(name = "user_id")) 
	private List<String> technology;
	
	@Column(name = "total_experience",nullable = false)
	private String totalExperience;
	
	@Column(name = "relevant_experience",nullable = false)
	private String relevantExperience;
	
	@NotNull
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "profile")
	@JsonManagedReference
	private List<EducationDetails> details;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "skill_id")
	private Skills skills;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "achievement_detail_id")
	private AchievementDetails achievementDetails;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "profile")
	@JsonManagedReference
	private List<ProjectDetails> projectDetails;
	
	@OneToMany(mappedBy = "profile",cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Summary> summary;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;

}
