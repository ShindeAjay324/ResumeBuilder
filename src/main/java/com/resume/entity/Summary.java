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
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "summary")
public class Summary {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer summaryId;
	
	@Column(name = "summary_details",nullable = false)
	private String summaryDetails;
	
	@ManyToOne
	@JsonBackReference
	private Profile profile;

}
