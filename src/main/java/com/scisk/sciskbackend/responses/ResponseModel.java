package com.scisk.sciskbackend.responses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseModel<T> extends ResponseEntity<T> {

    public ResponseModel(HttpStatus status) {
        super(status);
    }

    public ResponseModel(T body, HttpStatus status) {
        super(body, status);
    }
}
