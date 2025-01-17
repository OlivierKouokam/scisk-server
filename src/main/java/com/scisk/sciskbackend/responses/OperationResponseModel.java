package com.scisk.sciskbackend.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OperationResponseModel {
    private String message;

    public enum ResponseStatusEnum {
        SUCCESS, ERROR, WARNING, NO_ACCESS
    };
}
