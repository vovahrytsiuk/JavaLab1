package com.company.controller;

import com.company.model.*;
import com.company.view.*;

public class Controller {
    private View view = new View();
    private Filter filter = new Filter();

    public void calculate(){
        int x = InputUtility.readCommand(view);
        while(x!=0){
            switch(x){
                case 1:
                    view.printData(filter.getAllData());
                    break;
                case 2:
                    view.printData(filter.getByAppoinment(InputUtility.readAppointment()));
                    break;
                case 3:
                    view.printData(filter.getByQualification(InputUtility.readQualification()));
                    break;
                default:
                    view.printMessage(view.failedInputMessage);
                    break;
            }
            x = InputUtility.readCommand(view);
        }
    }
}
