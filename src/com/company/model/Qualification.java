package com.company.model;

public class Qualification {
    private String title;
    //here can be some additional info like qualification's id

    public Qualification(String title){
        this.title = title;
    }

    public Qualification(){
        //default constructor
    }

    public Qualification(Qualification qualification){
        this.title = qualification.title;
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


    public boolean equal(Qualification qualification){
        return this.title.equals(qualification.title);
    }
}
