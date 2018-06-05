package com.example.ltc_pc.myapplication;

import android.net.Uri;

public class User {

    private String name;
    private String email;
    private double id;
    private double mob;
    private String univ;
    private Uri url;

    public User(String name, String email, double id, double mob /*String univ*/,Uri url)
    {
        this.name= name;
        this.email=email ;
        this.id= id;
        this.mob=mob ;
       // this.univ= univ;
        this.url=url;

    }




    public void setName(String name)
    {this.name=name;}

    public void setEmail(String email)
    {this.email=email;}

    public void setID(int id)
    {this.id=id;}

    public void setMob(int mob)
    {this.mob=mob;}

   // public void setUniv(String univ)
    //{this.univ=univ;}

    public void setUrl(Uri url)
    {this.url=url;}
//////////////////////////////
    public String getName()
    {return name;}

    public String getEmail()
    {return email;}

    public double getID()
    {return id;}

   // public String getUniv()
  //  {return univ;}

    public double getMob()
    {return mob;}

    public Uri getUrl()
    {return url;}
}
