package com.company.model;

import java.util.Arrays;
import com.company.model.Randomaiser;

public class TechnicalTaskStorage {
    private TechnicalTask[] data = new TechnicalTask[10];

    public TechnicalTaskStorage(){
        Randomaiser randomaiser = new Randomaiser();
        for(int i = 0; i < data.length; i++){
            data[i] = new TechnicalTask(i+1, randomaiser.getRandomAppointment(), randomaiser.getRandomTasks(),
                    randomaiser.getRandomQualification(), randomaiser.getSpecialistCount());
        }
    }

    public TechnicalTask[] getAllData(){
        return Arrays.copyOf(this.data, this.data.length);
    }
}
