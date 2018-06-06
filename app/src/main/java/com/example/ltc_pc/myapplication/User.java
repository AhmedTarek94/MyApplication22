package com.example.ltc_pc.myapplication;

import android.net.Uri;

public class User {

    private String name;
    private String email;
    private String id;
    private String mob;
    //private String univ;
    private String url;

    public User(String name, String email, String id,String url)
    {
        this.name= name;
        this.email=email ;
        this.id= id;
       // this.mob=mob ;
       // this.univ= univ;
        this.url=url;

    }

    public User()
    {
       this.name="asl;";
       this.email="asl;";
       this.id="asl;";
       this.mob="asl;";
       this.url=null;
    }




    public void setName(String name)
    {this.name=name;}

    public void setEmail(String email)
    {this.email=email;}

    public void setID(String id)
    {this.id=id;}

    public void setMob(String mob)
    {this.mob=mob;}

   // public void setUniv(String univ)
    //{this.univ=univ;}

    public void setUrl(String url)
    {this.url=url;}
//////////////////////////////
    public String getName()
    {return name;}

    public String getEmail()
    {return email;}

    public String getID()
    {return id;}

   // public String getUniv()
  //  {return univ;}

    public String getMob()
    {return mob;}

    public String getUrl()
    {return url;}
}
