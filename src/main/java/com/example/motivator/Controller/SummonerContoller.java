package com.example.motivator.Controller;

import com.example.motivator.Controller.Common.UrlConstants;
import com.example.motivator.Controller.Common.UrlHelper;
import com.example.motivator.Model.LeagueEntryDTO;
import com.example.motivator.Model.Summoner;
import com.example.motivator.Model.SummonerDTO;
import com.example.motivator.Service.SummonerService;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;

@Controller
public class SummonerContoller implements UrlConstants {
    @Inject
    SummonerService summonerService;
    @Inject
    UrlHelper urlHelper;

    //    @RequestMapping(value = _GET_SUMMONER + "/{summonerName}", method = RequestMethod.POST)
    @RequestMapping(value = _GET_SUMMONER, method = RequestMethod.GET)
    public String getSummonerInfo(@ModelAttribute("summoner") Summoner summoner, @RequestParam("summonerName") String summonerName, Model model) throws IOException, URISyntaxException {

        URL urlObj = new URL(urlHelper.getSummonerInfo(summoner.getSummonerName()));
        HttpURLConnection urlConnection = (HttpURLConnection) urlObj.openConnection();

        InputStream is = urlConnection.getInputStream();
        StringBuilder out = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        while ((line = reader.readLine()) != null) {
            out.append(line);
        }
        reader.close();

        Gson g = new Gson();
        SummonerDTO summonerDTO = g.fromJson(out.toString(), SummonerDTO.class);

        String summonerTitle = summonerService.getSummonersTitle(summonerDTO.getName());

        RestTemplate template = new RestTemplate();
        URI uri = new URI(urlHelper.getSummonerLeagues(summonerDTO.getId()));
        String result = template.getForObject(uri, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        List<LeagueEntryDTO> leagueEntryDTOs = objectMapper.readValue(result, new TypeReference<List<LeagueEntryDTO>>(){});

        System.out.println(leagueEntryDTOs.toString());

        model.addAttribute("leagueEntryTft", leagueEntryDTOs.get(0));
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
