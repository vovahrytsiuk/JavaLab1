package com.company.model;

public class Task {
    private String title;
    //here can be some additional info like task's priority

    public Task(String title){
        this.title = title;
    }

    public Task(Task task){
        this.title = task.title;
    }

    public Task(){
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

    public boolean equal(Task task){
        return this.title.equals(task.title);
    }
}

