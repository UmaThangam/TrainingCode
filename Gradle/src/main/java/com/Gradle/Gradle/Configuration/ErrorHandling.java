package com.Gradle.Gradle.Configuration;


import com.Gradle.Gradle.Controller.RegisterController;
import com.Gradle.Gradle.Response.BloggingResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice//will be catch error in the application.
    public class ErrorHandling {
    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
        @ExceptionHandler(RuntimeException.class)
        public ResponseEntity handlingRunTimeExcpetion(RuntimeException e){
            BloggingResponse res = new BloggingResponse();
            logger.info("" +res);
            res.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(res);
        }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
