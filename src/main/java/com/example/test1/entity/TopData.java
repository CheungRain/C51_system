package com.example.test1.entity;

import lombok.Data;


public class TopData {
    private int temTop,humTop;
    public void setTemTop(int temTop){
        this.temTop = temTop;
    }
    public void setHumTop(int humTop){this.humTop = humTop;}
    public int getTemTop(){
        return temTop;
    }
    public int getHumTop(){
        return humTop;
    }
    @Override
    public String toString(){
        return "+IPD+"+getTemTop()+"+"+getHumTop();
    }
}
