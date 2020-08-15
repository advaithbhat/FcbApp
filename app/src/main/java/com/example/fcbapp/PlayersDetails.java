package com.example.fcbapp;

import java.io.Serializable;

public class PlayersDetails implements Serializable {
    public String fname,position,country,imagename,largeimage;
    public PlayersDetails(String fname,String country,String position,String imagename,String largeimage)
    {
        this.fname=fname;
        this.position=position;
        this.country=country;
        this.imagename=imagename;
        this.largeimage=largeimage;
    }
}
