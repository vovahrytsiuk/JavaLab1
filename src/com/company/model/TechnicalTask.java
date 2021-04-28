package com.company.model;

import java.util.Arrays;

public class TechnicalTask {
    private int number;
    private Appointment appointment;
    private Task[] tasks;
    private Qualification[] qualifications;
    private int specialistCount;

    public TechnicalTask(int number, Appointment appointment, Task[] tasks,
                         Qualification[] qualifications, int specialistCount){
        this.number = number;
        this.appointment = appointment;
        this.tasks = tasks.clone();
        this.qualifications = qualifications.clone();
        this.specialistCount = specialistCount;
    }

    public TechnicalTask(){
        //default constructor
    }

    public int getNumber(){
        return this.number;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public Appointment getAppointment(){
        return new Appointment(this.appointment);
    }

    public void setAppointment(Appointment appointment){
        this.appointment = new Appointment(appointment);
    }

    public Task[] getTasks(){
        return Arrays.copyOf(this.tasks, this.tasks.length);
    }

    public void setTasks(Task[] tasks){
        this.tasks = Arrays.copyOf(tasks, tasks.length);
    }

    public Qualification[] getQualifications(){
        return Arrays.copyOf(this.qualifications, this.qualifications.length);
    }

    public void setQualifications(Qualification[] qualifications){
        this.qualifications = Arrays.copyOf(qualifications, qualifications.length);
    }

    public int getSpecialistCount(){
        return this.specialistCount;
    }

    public void setSpecialistCount(int specialistCount){
        this.specialistCount = specialistCount;
    }

    @Override
    public String toString(){
        String techTaskView = String.valueOf(this.number);
        techTaskView += '\t';
        techTaskView += this.appointment.getTitle();
        techTaskView += '\t';
        techTaskView += Arrays.toString(this.tasks);
        techTaskView += '\t';
        techTaskView += Arrays.toString(this.qualifications);
        techTaskView += '\t';
        techTaskView += String.valueOf(this.specialistCount);
        
        return techTaskView;
    }




}



