package com.resume.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "achievement_details")
public class AchievementDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer achievementId;
	
	@Column(name = "achievement",nullable = false)
	private String achievement;

}
