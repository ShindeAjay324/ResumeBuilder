package com.resume.error.response;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponse {
    private String message;
    private List<String> errors = new ArrayList<>();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<String> getErrors() {
        return errors;
    }
}

