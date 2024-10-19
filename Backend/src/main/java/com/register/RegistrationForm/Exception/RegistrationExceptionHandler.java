package com.register.RegistrationForm.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice

public class RegistrationExceptionHandler {
	@ExceptionHandler(RegistrationNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> exceptionHandler(RegistrationNotFoundException exception){

        Map<String,String> errorMap=new HashMap<>();
        errorMap.put("errorMessage",exception.getMessage());

        return errorMap;

}
}