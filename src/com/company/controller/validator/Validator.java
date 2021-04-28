package com.company.controller.validator;

import com.company.controller.exceptions.EmptyAppointmentException;
import com.company.controller.exceptions.EmptyQualificationsException;
import com.company.controller.exceptions.FailCommandException;
import com.company.model.Appointment;
import com.company.model.Qualification;
import com.company.view.*;

public class Validator {
    public static void checkInputCommand(int commandID) throws FailCommandException{
        if( commandID < 0 || commandID > 3){
            throw new FailCommandException("Exception: " + View.failCommandMessage);
        }
    }

    public static void checkInputAppointment(Appointment appointment) throws EmptyAppointmentException{
        if(appointment.getTitle().equals("")){
            throw new EmptyAppointmentException("Exception: " + View.emptyAppointmentMessage);
        }
    }

    public static void checkInputQualifications(Qualification qualification) throws EmptyQualificationsException{
        if(qualification.getTitle().equals("")){
            throw new EmptyQualificationsException("Exception: " + View.emptyQualificationsMessage);
        }
    }
}
