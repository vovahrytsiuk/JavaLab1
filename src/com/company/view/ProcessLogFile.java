package com.company.view;


//class that used for printing information in txt file

import com.company.model.TechnicalTask;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProcessLogFile {
    private static final String feature1 = "All data in storage";
    private static final String feature2 = "Technical tasks for appointment :";
    private static final String feature3 = "Technical tasks for qualification :";


    public static void saveResultsToFile(TechnicalTask[] technicalTasks, int commandID, String keyWord)throws IOException{
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))){
            DateTimeFormatter dateTimeFormatter =
                    DateTimeFormatter.ofPattern("yyyy/MM/dd HH::mm::ss");

            LocalDateTime nowDate = LocalDateTime.now();
            writer.write(dateTimeFormatter.format(nowDate));
            writer.newLine();

            printCommand(writer, commandID, keyWord);
            printData(writer, technicalTasks);
            writer.newLine();

        }
        catch(IOException e){
            throw new IOException("Exception when trying ti write in txt file " +
                    e.getMessage());
        }
    }

    private static void printCommand(BufferedWriter writer, int commandID, String keyWord)throws IOException{
        switch (commandID){
            case 1 -> writer.write(feature1 );
            case 2 -> writer.write(feature2 + keyWord);
            case 3 -> writer.write(feature3 + keyWord);
        }
        writer.newLine();
    }

    private static void printData(BufferedWriter writer, TechnicalTask[] technicalTasks)throws IOException{
        if(technicalTasks.length != 0){

            writer.write(View.tableHead);
            writer.newLine();
            for(TechnicalTask technicalTask:technicalTasks){
                writer.write(technicalTask.toString());
                writer.newLine();
            }
        }
        else{
            writer.write(View.emptyTableMessage);
        }
    }
}
