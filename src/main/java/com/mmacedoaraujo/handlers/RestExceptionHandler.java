package com.mmacedoaraujo.handlers;

import com.mmacedoaraujo.exceptions.UserNotFoundException;
import com.mmacedoaraujo.exceptions.UserNotFoundExceptionDetails;
import com.mmacedoaraujo.exceptions.ValidationExceptionDetails;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<UserNotFoundExceptionDetails> handleUserNotFoundException(UserNotFoundException userNotFoundException) {
        return new ResponseEntity<>(
                UserNotFoundExceptionDetails.builder()
                        .title("User not found exception, please check the id")
                        .timeStamp(LocalDateTime.now())
                        .status(HttpStatus.NOT_FOUND.value())
                        .details(userNotFoundException.getMessage())
                        .developerMessage(userNotFoundException.getClass().getName()).build(), HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(", "));
        String fieldsMessage = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));

        return new ResponseEntity<>(ValidationExceptionDetails.builder()
                .timeStamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .title("User not found exception: Invalid field(s)")
                .details("Check the field(s) error")
                .developerMessage(ex.getClass().getName())
                .fields(fields)
                .fields(fieldsMessage)
                .build(), HttpStatus.NOT_FOUND);
    }
}
