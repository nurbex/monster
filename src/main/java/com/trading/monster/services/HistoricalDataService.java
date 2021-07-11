package com.trading.monster.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trading.monster.domain.AlpacaAccount;
import com.trading.monster.domain.HistoricalData;
import com.trading.monster.repositories.HistoricalDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class HistoricalDataService {

    @Autowired
    HistoricalDataRepository historicalDataRepository;

    public void saveAsset(HistoricalData historicalData){
        historicalDataRepository.save(historicalData);
    }

    public void getOneMinBars(){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.alpaca.markets/v2/account"))
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

        String json=response.body().toString();
        final ObjectMapper objectMapper = new ObjectMapper();
        HistoricalData historicalData = null;
        try {
            historicalData = objectMapper.readValue(json, new TypeReference<HistoricalData>(){});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        historicalDataRepository.save(historicalData);
    }
}
