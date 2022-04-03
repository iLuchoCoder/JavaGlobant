package com.hermes.msg.exceptions;

import com.hermes.msg.dto.ErrorsHandler;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExeptionHandler {

    @ExceptionHandler(HermesAppExeption.class)
    public ResponseEntity<ErrorsHandler> manageHermesAppException(HermesAppExeption exeption, WebRequest webRequest){
        ErrorsHandler errorsHandler = new ErrorsHandler(new Date(), exeption.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorsHandler, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UsersNotFoundException.class)
    public ResponseEntity<ErrorsHandler> manageUsersNotFoundException(UsersNotFoundException exeption, WebRequest webRequest){
        ErrorsHandler errorsHandler = new ErrorsHandler(new Date(), exeption.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorsHandler, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorsHandler> manageGlobalException(Exception exeption, WebRequest webRequest){
        ErrorsHandler errorsHandler = new ErrorsHandler(new Date(), exeption.getMessage(), webRequest.getDescription(false));
        return new ResponseEntity<>(errorsHandler, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
