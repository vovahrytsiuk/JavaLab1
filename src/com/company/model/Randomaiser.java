package com.company.model;

import java.util.Arrays;
import java.util.Random;

public class Randomaiser {
    private final Random random = new Random();
    private static final Appointment[] appointments = {new Appointment("Creating"), new Appointment("Fixing__"),
    new Appointment("Updating"), new Appointment("Debuging")};
    private static final Task[] tasks = {new Task("fix little bug"), new Task("fix  ui  adapt"),
    new Task("fix   backend "), new Task("fix  frontend "), new Task ("fix   mobile  "),
    new Task("new   feature "), new Task("new   backend "), new Task("new  frontend ")};
    private static final Qualification[] qualifications = {new Qualification("QA engeneer"), new Qualification(" recruiter "),
    new Qualification(" junior se "), new Qualification(" Senior SE "), new Qualification(" Middle SE "),
    new Qualification("HR manager ")};

    public Appointment getRandomAppointment(){

        return appointments[random.nextInt(1000000)%appointments.length];
    }

    public Task[] getRandomTasks(){
        Task[] newTasks = new Task[3];
        for(int i = 0; i < newTasks.length; i++){
            newTasks[i] = tasks[random.nextInt(1000000)% tasks.length];
        }
        return Arrays.copyOf(newTasks, newTasks.length);
    }

    public Qualification[] getRandomQualification(){
        Qualification[] newQuals = new Qualification[3];
        for(int i = 0; i < newQuals.length; i++){
            newQuals[i] = qualifications[random.nextInt(1000000)% qualifications.length];
        }
        return Arrays.copyOf(newQuals, newQuals.length);
    }

    public int getSpecialistCount(){
        return random.nextInt(100000)%100;
    }

}
