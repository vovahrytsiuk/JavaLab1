package com.company.model;

import java.io.IOException;
import java.util.Arrays;
import com.company.model.Randomaiser;
import org.json.simple.parser.ParseException;

public class TechnicalTaskStorage {
    private TechnicalTask[] data;

    public TechnicalTaskStorage(){
        data = new TechnicalTask[10];
        Randomaiser randomaiser = new Randomaiser();
        for(int i = 0; i < data.length; i++){
            data[i] = new TechnicalTask(i+1, randomaiser.getRandomAppointment(), randomaiser.getRandomTasks(),
                    randomaiser.getRandomQualification(), randomaiser.getSpecialistCount());
        }
    }

    public TechnicalTaskStorage(String filePath)throws IOException, ParseException {
        data = FileInteractionUtility.parseSourceData(filePath);
    }

    public TechnicalTask[] getAllData(){
        return Arrays.copyOf(this.data, this.data.length);
    }
}
