package br.com.codajovem.taskapi.controller;

import br.com.codajovem.taskapi.controller.dtos.ErrorApiDTO;
import br.com.codajovem.taskapi.controller.dtos.ErrorFormDTO;
import br.com.codajovem.taskapi.exception.BusinessException;
import br.com.codajovem.taskapi.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ErrorApiDTO<String> handlerResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorApiDTO<String> errors = new ErrorApiDTO<String>();
        errors.addError(ex.getMessage());
        return errors;
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(CONFLICT)
    public ErrorApiDTO<String> handlerBusinessException(BusinessException ex) {
        ErrorApiDTO<String> errors = new ErrorApiDTO<String>();
        errors.addError(ex.getMessage());
        return errors;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorApiDTO<ErrorFormDTO> handlerMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ErrorApiDTO<ErrorFormDTO> errors = new ErrorApiDTO<ErrorFormDTO>();
        for (FieldError fieldError : ex.getFieldErrors()) {
            errors.addError(
                    ErrorFormDTO.builder()
                            .field(fieldError.getField())
                            .message(fieldError.getDefaultMessage())
                            .build()
            );
        }
        return errors;
    }
}
