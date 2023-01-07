package io.ahakim.crud.dto;

import lombok.ToString;
import org.springframework.http.HttpStatus;

@ToString
public class ApiError {

    private final String message;

    private final int status;

    public ApiError(Throwable throwable, HttpStatus status) {
        this(throwable.getMessage(), status);
    }

    public ApiError(String message, HttpStatus status) {
        this.message = message;
        this.status = status.value();
    }
}