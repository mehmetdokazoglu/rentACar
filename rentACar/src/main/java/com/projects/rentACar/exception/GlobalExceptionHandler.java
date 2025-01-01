package com.projects.rentACar.exception;

import com.projects.rentACar.core.result.ErrorResult;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResult handleViolationException(DataIntegrityViolationException violationException) {
        String errorMessage = "Bu veri, veritabanında kayıtlı";
        return new ErrorResult(errorMessage);
    }
}
