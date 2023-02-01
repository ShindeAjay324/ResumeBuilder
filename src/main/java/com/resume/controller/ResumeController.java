package com.resume.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.resume.dto.ProfileDto;
import com.resume.response.Response;
import com.resume.service.ProfileService;

@RestController
public class ResumeController {
	@Autowired
	private Response response;
	
	@Autowired
	private ProfileService profileService;
	
	@PostMapping("/{userId}/reumeInfo")
	public ResponseEntity<Response> resumeInfo(@RequestBody ProfileDto profileDto,@PathVariable Integer userId ){
		
		ProfileDto profileDto2=profileService.resumeInfo(profileDto,userId);
		if (profileDto2!=null) {
			response.setError(false);
			response.setMessage("resume created");
			response.setStatus("200");
			response.setList(Arrays.asList(profileDto2));
			return new ResponseEntity<>(response,HttpStatus.FOUND);
		}else {
			response.setError(true);
			response.setStatus("401");
			response.setMessage("Resume is not created");
			response.setList(Arrays.asList(profileDto2));
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
			
		}
		
	}
	
	
}
