package com.workintech.s18d2.exceptions;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.net.http.HttpClient;

@Getter
@Setter
@AllArgsConstructor
public class PlantException extends RuntimeException {

    private HttpStatus httpStatus;

    public PlantException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
