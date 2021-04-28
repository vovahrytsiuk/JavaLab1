package com.company.controller.exceptions;

import java.io.IOException;

public class EmptyQualificationsException extends IOException {
    public EmptyQualificationsException(String message){
        super(message);
    }
}
