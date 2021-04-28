package com.company.model;

import java.util.Arrays;

public class Filter {
    private TechnicalTaskStorage storage = new TechnicalTaskStorage();

    public TechnicalTask[] getAllData(){
        return storage.getAllData();
    }

    private boolean checkQualificationsIsTechnicalTask(TechnicalTask task, Qualification qualification){
        Qualification[] qualifications = task.getQualifications();
        for(Qualification qualification1:qualifications){
            if(qualification1.equal(qualification)){
                return true;
            }
        }
        return false;
    }

    public TechnicalTask[] getByAppoinment(Appointment appointment){
        TechnicalTask[] data = storage.getAllData();
        TechnicalTask[] filteredData = new TechnicalTask[data.length];
        int k = 0;
        for(TechnicalTask task : data){
            if(task.getAppointment().equal(appointment)){
                filteredData[k] = task;
                k++;
            }
        }
        return Arrays.copyOf(filteredData, k);
    }

    public TechnicalTask[] getByQualification(Qualification qualification){
        TechnicalTask[] data = storage.getAllData();
        TechnicalTask[] filteredData = new TechnicalTask[data.length];
        int k = 0;
        for(TechnicalTask task : data){
            if(checkQualificationsIsTechnicalTask(task, qualification)){
                filteredData[k] = task;
                k++;
            }
        }
        return Arrays.copyOf(filteredData, k);
    }
}

