package com.company.view;

import com.company.model.Appointment;
import com.company.model.Qualification;

import java.util.Scanner;

public class InputUtility {
    public static int readCommand(View view){
        int commandID;
        Scanner scanner = new Scanner(System.in);
        view.printMessage(view.menuMessage);
        do{
            while(!scanner.hasNextInt()){
                view.printMessage(view.failedInputMessage);
                view.printMessage(view.menuMessage);
                scanner.next();
            }
            commandID = scanner.nextInt();
            if(commandID < 0 || commandID > 3){
                view.printMessage(view.failedInputMessage);
                view.printMessage(view.menuMessage);
            }

        }
        while(commandID < 0 || commandID > 3);
        return commandID;
    }

    public static Appointment readAppointment(View view){
        Scanner scanner = new Scanner(System.in);
        view.printMessage(view.requestAppointmentMessage);
        String appointmentTitle = scanner.nextLine();
        return new Appointment(appointmentTitle);
    }

    public static Qualification readQualification(View view){
        view.printMessage(view.requestQualificationMessage);
        Scanner scanner = new Scanner(System.in);
        String qualificationTitle = scanner.nextLine();
        return new Qualification(qualificationTitle);
    }



}
