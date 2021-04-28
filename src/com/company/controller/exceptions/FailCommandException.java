package com.company.controller.exceptions;

import java.io.IOException;

public class FailCommandException extends IOException {
    public FailCommandException(String message){
        super(message);
    }
}
