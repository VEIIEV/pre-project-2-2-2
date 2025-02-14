package org.example.preproject222.controller.advices;


import org.example.preproject222.exception.UnsupportedSortByException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

@ControllerAdvice
public class GlobalValidationExceptionHandler extends DefaultHandlerExceptionResolver {

    @ExceptionHandler(UnsupportedSortByException.class)
    public ResponseEntity<String> handleValidationExceptions(UnsupportedSortByException ex) {

        String errors = ex.getMessage() + ": " + String.join(", ", ex.getUsedSortBy());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


}
