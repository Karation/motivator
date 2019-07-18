package com.example.motivator.Model;

import org.springframework.web.bind.annotation.ModelAttribute;

public class Summoner{
    private String summonerName;

    public Summoner(String summonerName) {
        this.summonerName = summonerName;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }
}
