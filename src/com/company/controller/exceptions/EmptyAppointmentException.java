package com.company.controller.exceptions;

import java.io.IOException;

public class EmptyAppointmentException extends IOException {
    public EmptyAppointmentException(String message){
        super(message);
    }
}
