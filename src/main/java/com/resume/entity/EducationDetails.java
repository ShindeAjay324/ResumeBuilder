package com.resume.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "education_details")
public class EducationDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer educationId;
	
	@NotNull
	@Column(name = "education")
	private String education;
	
	@NotNull
	@Column(name = "specilization")
	private String specilization;
	
	@NotNull
	@Column(name = "university")
	private String university;
	
	@NotNull
	@Column(name = "pass_out_year")
	private Integer passOutYear;
	
	@NotNull
	@Column(name ="percentage")
	private Double percentage;
	
	@ManyToOne
	@JsonBackReference
	private Profile profile;

}
