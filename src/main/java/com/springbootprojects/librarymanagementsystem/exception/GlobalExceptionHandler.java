package com.springbootprojects.librarymanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex) {
        EntityException entityException = new EntityException(
                ex.getMessage(),
                ex.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(entityException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {EntityAlreadyExistsException.class})
        public ResponseEntity<Object> handleEntityAlreadyExistsException(EntityAlreadyExistsException entityAlreadyExistsException){
            EntityException entityException = new EntityException(
                  entityAlreadyExistsException.getMessage(),
                    entityAlreadyExistsException.getCause(),
                    HttpStatus.CONFLICT
            );
            return new ResponseEntity<>(entityException, HttpStatus.CONFLICT);
    }

}