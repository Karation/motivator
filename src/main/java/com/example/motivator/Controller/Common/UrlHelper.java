package com.example.motivator.Controller.Common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("url")
public class UrlHelper implements UrlConstants{

    @Value("${lol.api.key}")
    private String apiKey;

    public String getSummonerInfo(String summonerName){return riotUrl + _LOL + _SUMMONER + _V4 + _SUMMONERS + _BY_NAME + "/" + summonerName + "?api_key=" + apiKey;}
    public String getSummonerLeagues(String summonerId){return riotUrl + _LOL + _LEAGUE + _V4 + _ENTRIES + _BY_SUMMONER + "/" + summonerId + "?api_key=" + apiKey;}
    public String getIconImage(long id){
        return iconsUrl + "/" + id + ".png";
    }
}
