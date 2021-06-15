package com.desafio.social_meli.controller.advice;

import com.desafio.social_meli.dtos.error.ErrorDTO;
import com.desafio.social_meli.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({UserNotFoundException.class})
    public ErrorDTO handleUserNotFoundException(RuntimeException e) {
        return new ErrorDTO(e.getMessage(), LocalDateTime.now());
    }

}
