package com.narel.online_store.MyException;

import com.narel.online_store.Dto.CPUDto;

import static java.util.Objects.isNull;

public class ValidationException extends Exception {
    private String message;

    public ValidationException(String message){

    }
    public String getMessage(){

        return message;
    }

}