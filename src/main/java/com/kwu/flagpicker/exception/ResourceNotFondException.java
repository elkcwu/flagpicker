package com.kwu.flagpicker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFondException extends Exception {
    private static final long serialVersionUID = 1L;

    public ResourceNotFondException(String message){
        super(message);
    }

}
