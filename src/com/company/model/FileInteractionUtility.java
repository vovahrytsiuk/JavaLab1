package com.company.model;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;





import com.company.model.TechnicalTask;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// class that can read/write array of technical tasks from json format and save search result in txt file
public class FileInteractionUtility {

    private static void readData(JSONArray ttData, TechnicalTask[] technicalTasks){
        int i = 0;
        for(Object ttObject:ttData){
            JSONObject ttJsonObject = (JSONObject) ttObject;
            technicalTasks[i] = (new TechnicalTask((int)(long) ttJsonObject.get("number"),
                    new Appointment((String)ttJsonObject.get("appointment")),
                    parseTaskArray((JSONArray) ttJsonObject.get("tasks")),
                    parseQualificationArray((JSONArray) ttJsonObject.get("qualifications")),
                    (int)(long) ttJsonObject.get("specialistCount")));
            i++;
        }
    }

    private static Task[] parseTaskArray(JSONArray jsonArray){
        Task[] tasks = new Task[jsonArray.size()];
        int i = 0;
        for(Object value:jsonArray){
            JSONObject valueJson = (JSONObject) value;
            tasks[i] = new Task((String) valueJson.get("title"));
            i++;
        }

        return tasks;
    }

    private static Qualification[] parseQualificationArray(JSONArray jsonArray){
        Qualification[] qualifications = new Qualification[jsonArray.size()];
        int i = 0;
        for(Object value:jsonArray){
            JSONObject valueJson = (JSONObject) value;
            qualifications[i] = new Qualification((String) valueJson.get("title"));
            i++;
        }

        return qualifications;
    }


    public static TechnicalTask[] parseSourceData(String filePath)throws IOException, ParseException{
        // place to save readed data


        //json parser
        JSONParser jsonParser = new JSONParser();
        try(FileReader reader = new FileReader(filePath)){
            JSONObject mainObject = (JSONObject) jsonParser.parse(reader);
            JSONArray ttData = (JSONArray) mainObject.get("technicalTasks");
            TechnicalTask[] technicalTasks = new TechnicalTask[ttData.size()];
            readData(ttData, technicalTasks);

            return technicalTasks;
        }
        catch (IOException err){
            throw new IOException("Read data from json " +err.getMessage());
        }
        catch (ParseException err){
            throw new ParseException(err.getErrorType());
        }
    }

    private static void dataToJsonArray(JSONArray jsonArray, TechnicalTask[] technicalTasks){
        for(TechnicalTask technicalTask : technicalTasks){
            JSONObject ttJsonObject = new JSONObject();
            ttJsonObject.put("number", technicalTask.getNumber());
            ttJsonObject.put("appointment", technicalTask.getAppointment().toString());

            ttJsonObject.put("tasks",dataToJsonInArray(convertTasksArrayToStringArray(technicalTask.getTasks())));
            ttJsonObject.put("qualifications", dataToJsonInArray(convertQualificationsArrayToStringArray(technicalTask.getQualifications())));
            ttJsonObject.put("specialistCount", technicalTask.getSpecialistCount());
            jsonArray.add(ttJsonObject);
        }
    }

    private static<T> JSONArray dataToJsonInArray(T[] data){
        JSONArray jsonArray = new JSONArray();
        for(T value : data){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("title", value);
            jsonArray.add(jsonObject);
        }
        return  jsonArray;
    }

    public static void saveDataToJson(TechnicalTask[] technicalTasks, String filepath)throws IOException{
        try(FileWriter writer = new FileWriter(filepath)){
            JSONObject jsonObject = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            dataToJsonArray(jsonArray, technicalTasks);
            jsonObject.put("technicalTasks", jsonArray);
            writer.write(jsonObject.toJSONString());
        }
        catch(IOException err){
            throw new IOException("Save data to json exception " + err.getMessage());
        }
    }


    private static String[] convertTasksArrayToStringArray(Task[] tasks){
        String [] newTasks = new String[tasks.length];
        for(int i = 0; i < tasks.length; i++){
            newTasks[i] = tasks[i].getTitle();
        }

        return newTasks;
    }

    private static String[] convertQualificationsArrayToStringArray(Qualification[] qualifications){
        String [] newQualifications = new String[qualifications.length];
        for(int i = 0; i < qualifications.length; i++){
            newQualifications[i] = qualifications[i].getTitle();
        }
        return newQualifications;
    }


}
