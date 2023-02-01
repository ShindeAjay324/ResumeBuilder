package com.resume.response;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Response {
	private boolean error;
	private String status;
	private String message;
	private Object List;
}
