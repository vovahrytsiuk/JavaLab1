package com.company.controller;

import com.company.controller.exceptions.EmptyAppointmentException;
import com.company.controller.exceptions.EmptyQualificationsException;
import com.company.controller.exceptions.FailCommandException;
import com.company.controller.validator.Validator;
import com.company.model.*;
import com.company.view.*;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Controller {
    private View view = new View();
    private Filter filter;


    private int readValidCommand(){
        int commandID;
        while(true){
            try{
                commandID = InputUtility.readCommand(view);
                Validator.checkInputCommand(commandID);
                break;
            }
            catch(FailCommandException exc){
                View.printMessage(exc.getMessage());
            }
        }
        return commandID;
    }

    private void printDataByAppointment(){
        while(true){
            try{
                Appointment newAppointment = InputUtility.readAppointment(view);
                Validator.checkInputAppointment(newAppointment);
                View.printData(filter.getByAppoinment(newAppointment));
                break;
            }
            catch(EmptyAppointmentException exc){
                View.printMessage(exc.getMessage());
            }
        }
    }

    private void printDataByQualifications(){
        while(true){
            try{
                Qualification newQualification = InputUtility.readQualification(view);
                Validator.checkInputQualifications(newQualification);
                View.printData(filter.getByQualification(newQualification));
                break;
            }
            catch(EmptyQualificationsException exc){
                View.printMessage(exc.getMessage());
            }
        }
    }

    private void requestsSaving(){
        try{
            FileInteractionUtility.saveDataToJson(filter.getAllData(), "data.json");
        }catch (IOException e){
            view.printMessage(e.getMessage());
        }
    }

    public void calculate(){
        try {
            this.filter = new Filter("data.json");
            int commandID = readValidCommand();
            while(commandID!=0){
                switch (commandID) {
                    case 1 -> View.printData(this.filter.getAllData());
                    case 2 -> printDataByAppointment();
                    case 3 -> printDataByQualifications();
                    default -> View.printMessage(View.failedInputMessage);
                }
                commandID = readValidCommand();
            }
            //requests to save data
            requestsSaving();
        }
        catch (Exception e){
            View.printMessage(e.getMessage());
        }

    }
}
