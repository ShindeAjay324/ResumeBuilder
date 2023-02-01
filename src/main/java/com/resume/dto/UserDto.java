package com.resume.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class UserDto {
	private String userName;
	private String userPassword; 
	private List<ProfileDto> profile;
}
