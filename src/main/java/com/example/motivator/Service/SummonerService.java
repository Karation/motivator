package com.example.motivator.Service;

import org.springframework.stereotype.Service;

@Service
public class SummonerService {

    public String getSummonersTitle(String name){
        switch (name){
            case "Senegalius":
                return "Gay Yordl";
            case "hrabo1337":
                return "CapGayini";
            case "Carheas":
                return "Gay but Married";
            case "dagorek":
                return "Gay Stealer";
            case "KotCieSrol":
                return "Gaysassin";
            case "Hag Queen":
                return "Gay, but that's fair";
            case "LongDrongPirate":
                return "With that nick? Must be Gay Captain";
            case "BrodatyBarnaba":
                return "Techno Gayking";
            case "DalSharumm":
                return "GayShalom";
            case "Vason":
                return "Definitely not gay";
            case "Vamerius":
                return "Gayren";
             default:
                return "Unknown but probably gay";
        }

    }
}
