package com.resume.advice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.resume.error.response.ErrorResponse;
import com.resume.exception.ResumeException;
import com.resume.exception.UserIdNotFoundException;
import com.resume.exception.UserNameNotFoundException;
import com.resume.response.Response;

@RestControllerAdvice
public class AppExceptionController {
	@Autowired
	private Response response;
	
	@ExceptionHandler(ResumeException.class)
	public ResponseEntity<Response> ResumeException(ResumeException ex){
		response.setStatus("404");
		response.setMessage(ex.getMessage());
		//response.setList(null);
		
		return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage("Validation Error");

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            errorResponse.getErrors().add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
        }

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(UserIdNotFoundException.class)
	public ResponseEntity<Response> UserIdNotFoundException(UserIdNotFoundException ex){
		response.setStatus("404");
		response.setMessage(ex.getMessage());
		
		return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserNameNotFoundException.class)
	public ResponseEntity<Response> UserNameNotFoundException(UserNameNotFoundException ex){
		response.setStatus("404");
		response.setMessage(ex.getMessage());
		
		return new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
	}
	
}
