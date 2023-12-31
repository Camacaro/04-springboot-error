package com.jesus.courses.springboot.error.app.errors;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String id) {
        super("User with ID: ".concat(id).concat(" no exists in the system"));
    }
}
