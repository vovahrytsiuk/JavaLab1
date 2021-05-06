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
                TechnicalTask[] data = filter.getByAppoinment(newAppointment);
                View.printData(data);
                ProcessLogFile.saveResultsToFile(data, 2, newAppointment.getTitle());
                break;
            }
            catch(EmptyAppointmentException exc){
                View.printMessage(exc.getMessage());
            }
            catch(IOException e){
                View.printMessage(e.getMessage());
            }
        }
    }

    private void printDataByQualifications(){
        while(true){
            try{
                Qualification newQualification = InputUtility.readQualification(view);
                Validator.checkInputQualifications(newQualification);
                TechnicalTask[]data = filter.getByQualification(newQualification);
                View.printData(data);
                ProcessLogFile.saveResultsToFile(data, 3, newQualification.getTitle());
                break;
            }
            catch(EmptyQualificationsException exc){
                View.printMessage(exc.getMessage());
            }
            catch(IOException e){
                View.printMessage(e.getMessage());
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

    private int readLoadCommand(){
        int commandID;
        while(true){
            try{
                commandID = InputUtility.rearInt(view);
                Validator.checkInputCommand(commandID);
                if(commandID == 0 || commandID == 1){
                    break;
                }
            }
            catch(FailCommandException exc){
                View.printMessage(exc.getMessage());
            }
        }
        return commandID;
    }

    public void calculate(){
        try {
            if(readLoadCommand() == 1){
                this.filter = new Filter("data.json");
            }
            else{
                this.filter = new Filter();
            }

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
