package com.hermes.msg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UsersNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private String resourceName;
    private String nameField;
    private long fieldValue;

    public UsersNotFoundException(String resourceName, String nameField, long fieldValue) {
        super(String.format("%s not found with : %s : '%s'",resourceName,nameField,fieldValue));
        this.resourceName = resourceName;
        this.nameField = nameField;
        this.fieldValue = fieldValue;
    }
}
