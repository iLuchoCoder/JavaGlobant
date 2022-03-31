package com.hermes.msg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private String username;

    public UserNotFoundException(String username) {
        super(String.format("Username %s not found ", username));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
