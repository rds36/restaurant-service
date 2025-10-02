package com.rds.restaurantservice.exception;

import com.rds.securitylib.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class RestaurantExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleDataNotFoundException(DataNotFoundException e, WebRequest request){
        return new ResponseEntity<>(
                new ErrorResponse(
                        request.getDescription(false),
                        e.getMessage(),
                        HttpStatus.NOT_FOUND,
                        LocalDateTime.now()
                ),
                HttpStatus.NOT_FOUND
        );
    }
}
