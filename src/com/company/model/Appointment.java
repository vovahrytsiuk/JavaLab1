package com.company.model;

public class Appointment {
    private String title;
    //here can be some info like additional description

    public Appointment(String title) {
        this.title = title;
    }

    public Appointment(Appointment appointment){
        this.title = appointment.title;
    }

    public Appointment(){
        //default constructor
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    @Override
    public String toString(){
        return this.title;
    }

    public boolean equal(Appointment appointment){
        return this.title.equals(appointment.title);
    }
}
