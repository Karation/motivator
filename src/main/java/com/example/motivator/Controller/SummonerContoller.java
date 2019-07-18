package com.example.motivator.Controller;

import com.example.motivator.Controller.Common.UrlConstants;
import com.example.motivator.Controller.Common.UrlHelper;
import com.example.motivator.Model.Summoner;
import com.example.motivator.Model.SummonerDTO;
import com.example.motivator.Service.SummonerService;

import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Controller
public class SummonerContoller implements UrlConstants{
    @Inject
    SummonerService summonerService;
    @Inject
    UrlHelper urlHelper;

//    @RequestMapping(value = _GET_SUMMONER + "/{summonerName}", method = RequestMethod.POST)
    @RequestMapping(value = _GET_SUMMONER, method = RequestMethod.GET)
    public String getSummonerInfo(@ModelAttribute("summoner") Summoner summoner, @RequestParam("summonerName") String summonerName, Model model) throws IOException {

        URL urlObj = new URL(urlHelper.getSummonerInfo(summoner.getSummonerName()));
        HttpURLConnection urlConnection = (HttpURLConnection) urlObj.openConnection();
        String response = urlConnection.getResponseMessage();
        InputStream is = urlConnection.getInputStream();
        StringBuilder out = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = reader.readLine()) != null) {
            out.append(line);
        }
        System.out.println(out.toString());   //Prints the string content read from input stream
        reader.close();

        Gson g = new Gson();
        SummonerDTO summonerDTO = g.fromJson(out.toString(), SummonerDTO.class);

        String summonerTitle = summonerService.getSummonersTitle(summonerDTO.getName());

        model.addAttribute("summonerDTO", summonerDTO);
        model.addAttribute("summonerTitle", summonerTitle);
        model.addAttribute("summonerIconUrl", urlHelper.getIconImage(summonerDTO.getProfileIconId()));
        return "summoner-info.html";
    }


    @GetMapping("/")
    public String indexPage() {
        return "index";
    }
}
