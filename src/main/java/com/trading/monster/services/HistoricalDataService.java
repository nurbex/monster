package com.trading.monster.services;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trading.monster.domain.AlpacaAsset;
import com.trading.monster.domain.HistoricalData;
import com.trading.monster.domain.OneMinuteBar;
import com.trading.monster.repositories.OneMinuteBarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class HistoricalDataService {

    @Autowired
    OneMinuteBarRepository oneMinuteBarRepository;

    public void saveData(OneMinuteBar oneMinuteBar){
        oneMinuteBarRepository.save(oneMinuteBar);
    }

    public void getOneMinBars(){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://data.alpaca.markets/v1/bars/1Min?symbols=AAPL&limit=1000&start&end&after&until"))
                .header("APCA-API-KEY-ID", "AK5S1P2OGBCPIZDZWER3")
                .header("APCA-API-SECRET-KEY", "vPQUEJeuOUNgARBNXOmUS1gD2R4s3aiTUBN87bm7")
                .header("Content-Type", "application/json")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //System.out.println(response.body());

        String json=response.body();
        //System.out.println(json);

        final ObjectMapper objectMapper = new ObjectMapper();
        HistoricalData AAPL;
        try {
            AAPL = objectMapper.readValue(json, HistoricalData.class);
            System.out.println(AAPL.toString());

            for (OneMinuteBar oneMinuteBar: AAPL.getAAPL()) {
                oneMinuteBarRepository.save(oneMinuteBar);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
