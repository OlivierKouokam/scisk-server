package com.scisk.sciskbackend.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleObjectResponseModel<T> extends OperationResponseModel {

    private T item;

    public SimpleObjectResponseModel(String message, T item) {
        super(message);
        this.item = item;
    }
}