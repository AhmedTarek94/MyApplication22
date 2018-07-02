package com.example.ltc_pc.myapplication;

/**
 * Created by LTC-PC on 6/24/2018.
 */

public class Event {

    String name,date,location;

    public Event(String name,String date,String location)
    {
        this.name=name;
        this.date=date;
        this.location=location;
    }

    public String getName()
    {
        return this.name;
    }

    public String getDate()
    {
        return this.date;
    }

    public String getLoc()
    {
        return this.location;
    }

}
