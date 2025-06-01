package com.example.student.core.base.exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleEntityNotFound(EntityNotFoundException e, WebRequest request){
        return createMessage(HttpStatus.NOT_FOUND, "Not Found", e.getMessage());
    }

    private ResponseEntity<Map<String, Object>> createMessage(HttpStatus status, String error, Object message){
        Map<String, Object> map = new HashMap<>();
        map.put("timeStamp", LocalDate.now());
        map.put("status", status);
        map.put("error", error);
        map.put("message", message);
        return new ResponseEntity<>(map, status);
    }

}
