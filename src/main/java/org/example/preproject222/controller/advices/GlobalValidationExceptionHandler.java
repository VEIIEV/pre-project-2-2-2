package org.example.preproject222.controller.advices;


import jakarta.persistence.EntityNotFoundException;
import org.example.preproject222.config.CarProperties;
import org.example.preproject222.exception.UnsupportedSortByException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

@ControllerAdvice
public class GlobalValidationExceptionHandler extends DefaultHandlerExceptionResolver {

    private final CarProperties carProperties;

    @Autowired
    public GlobalValidationExceptionHandler(CarProperties carProperties) {
        this.carProperties = carProperties;
    }

    @ExceptionHandler(UnsupportedSortByException.class)
    public ResponseEntity<String> handleValidationExceptions(UnsupportedSortByException ex) {

        String errors = ex.getMessage() + ": " +
                String.join(", ", ex.getUsedSortBy()) +
                "\n Allowed Sort list: " +
                String.join(", ", carProperties.getSort().getAllowed());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleValidationExceptions(EntityNotFoundException ex) {

        String errors = ex.getMessage();
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


}
