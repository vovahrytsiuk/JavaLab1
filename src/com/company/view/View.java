package com.company.view;

import com.company.model.*;

public class View {
    public static final String emptyTableMessage = "Table is empty/n";
    public static final String menuMessage = "Please, choose the feature\n" +
            "\t0-Exit\n" +
            "\t1-Get all data\n" +
            "\t2-Get data for appointment\n" +
            "\t3-Get data for qualification";
    public static final String requestAppointmentMessage = "Enter the appointment to filter data\n";
    public static final String requestQualificationMessage = "Enter the qualification to filter data\n";
    public static final String failedInputMessage = "Wrong input\n";

    public static void printMessage(String message){
        System.out.println(message);
    }

    public static void printData(TechnicalTask[] data){
        if(data.length != 0){
            for(TechnicalTask technicalTask:data){
                printMessage(technicalTask.toString());
            }
        }
        else{
            printMessage(emptyTableMessage);
        }
    }


}
