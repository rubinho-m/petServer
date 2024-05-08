package com.petproject.petserver.controllers;

import com.petproject.petserver.exceptions.AppException;
import com.petproject.petserver.model.dto.ErrorDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {AppException.class})
    public ResponseEntity<ErrorDTO> handleException(AppException ex) {
        return ResponseEntity.status(ex.getStatus())
                .body(ErrorDTO.builder().message(ex.getMessage()).build());
    }


}