package com.resume.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.resume.dto.ProfileDto;
import com.resume.dto.UserDto;
import com.resume.response.Response;
import com.resume.service.UserService;

@RestController
public class RegistrationController {
	@Autowired
	private Response response;
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/register")
	public ResponseEntity<Response> registerUser(@RequestBody UserDto userDto){
		
		UserDto newUserDto=userService.registerUser(userDto);
		if (userDto!=null) {
			response.setError(false);
			response.setMessage("User register");
			response.setStatus("200");
			response.setList(Arrays.asList(userDto));
			return new ResponseEntity<>(response,HttpStatus.FOUND);
		}else {
			response.setError(true);
			response.setStatus("401");
			response.setMessage("Oops Something went Wrong");
			response.setList(Arrays.asList(userDto));
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
			
		}
		
	}
}
