package com.devops.springboot_app.exception;

public class DuplicateEmployeeException extends RuntimeException {

    public DuplicateEmployeeException(String field, String value) {
        super(field + " already exists : " + value);
    }

}