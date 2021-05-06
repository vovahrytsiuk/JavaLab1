package com.company.view;

import com.company.model.*;

public class View {
    public static final String emptyTableMessage = "No results";
    public static final String menuMessage = "Please, choose the feature\n" +
            "\t0-Exit\n" +
            "\t1-Get all data\n" +
            "\t2-Get data for appointment\n" +
            "\t3-Get data for qualification";
    public static final String requestAppointmentMessage = "Enter the appointment to filter data";
    public static final String requestQualificationMessage = "Enter the qualification to filter data";
    public static final String failedInputMessage = "Wrong input\n";
    public static final String tableHead = "Num Appointment \t\t\t\t\t Tasks \t\t\t\t\t\t\t\t\t\t Qualifications\t\t\t\tSpecCount ";
    public static final String failCommandMessage = "Wrong input command";
    public static final String emptyAppointmentMessage = "Wrong input appointment - appointment can't be empty";
    public static final String emptyQualificationsMessage = "Wrong input qualifications - qualifications can't be empty";
    public static final String loadOrGenerateDataMessage = "Do u want to load saved data? Enter 0/1";

    public static void printMessage(String message){
        System.out.println(message);
    }

    public static void printData(TechnicalTask[] data){

        if(data.length != 0){
            printMessage(tableHead);
            for(TechnicalTask technicalTask:data){
                printMessage(technicalTask.toString());
            }
        }
        else{
            printMessage(emptyTableMessage);
        }
    }


}
