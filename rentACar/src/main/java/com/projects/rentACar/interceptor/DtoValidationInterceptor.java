package com.projects.rentACar.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projects.rentACar.core.result.ErrorDataResult;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;

@ControllerAdvice
public class DtoValidationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public void handleValidationException(MethodArgumentNotValidException validException, HttpServletResponse response) {
        try {
            String message = validException.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
            ErrorDataResult<Void> errorDataResult = new ErrorDataResult<>(null, message);
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setContentType("application/json");
            response.getWriter().write(new ObjectMapper().writeValueAsString(errorDataResult));
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public void handleConstraintViolationException(ConstraintViolationException violationException, HttpServletResponse response) {
        try {
            String message = violationException.getConstraintViolations().iterator().next().getMessage();
            ErrorDataResult<Void> errorDataResult = new ErrorDataResult<>(null, message);
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            response.setContentType("application/json");
            response.getWriter().write(new ObjectMapper().writeValueAsString(errorDataResult));
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}
