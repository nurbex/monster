package com.trading.monster.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class HistoricalDataService {

    @Autowired
    OneMinuteBarRepository oneMinuteBarRepository;

    public void saveData(OneMinuteBar oneMinuteBar){
        oneMinuteBarRepository.save(oneMinuteBar);
    }

    public void getOneMinBars(LocalDate startingDate){
        LocalDate endDate=LocalDate.parse("2021-07-12");
        int limit=1000;

            //endDate=startingDate.plusDays(1);
            System.out.println(startingDate);
            System.out.println(endDate);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://data.alpaca.markets/v2/stocks/AAPL/bars?start="+startingDate+"&end="+endDate+"&limit&page_token&timeframe=1Min"))
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
            System.out.println(response.body());

            String json=response.body();
            //System.out.println(json);

            final ObjectMapper objectMapper = new ObjectMapper();
            HistoricalData historicalData;
            try {
                historicalData = objectMapper.readValue(json, HistoricalData.class);
                //System.out.println(AAPL.toString());

                String pageToken=null;

                do{
                     //saves first respond and check if it hase next page
                     for (OneMinuteBar oneMinuteBar: historicalData.getBars()) {
                         oneMinuteBarRepository.save(oneMinuteBar);
                     }
                     pageToken= historicalData.getNext_page_token();
                    System.out.println(pageToken);
                     if(!(pageToken == null)){
                     HttpRequest requestWhile = HttpRequest.newBuilder()
                             .uri(URI.create("https://data.alpaca.markets/v2/stocks/AAPL/bars?start="+startingDate+"&end="+endDate+"&limit="+limit+"&page_token="+pageToken+"&timeframe=1Min"))
                             .header("APCA-API-KEY-ID", "AK5S1P2OGBCPIZDZWER3")
                             .header("APCA-API-SECRET-KEY", "vPQUEJeuOUNgARBNXOmUS1gD2R4s3aiTUBN87bm7")
                             .header("Content-Type", "application/json")
                             .method("GET", HttpRequest.BodyPublishers.noBody())
                             .build();
                     HttpResponse<String> responseWhile = null;
                     try {
                         responseWhile = HttpClient.newHttpClient().send(requestWhile, HttpResponse.BodyHandlers.ofString());
                         System.out.println(responseWhile.statusCode());
                     } catch (IOException e) {
                         e.printStackTrace();
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }


                     String jsonWhile=responseWhile.body();
                     //System.out.println(jsonWhile);

                     historicalData = objectMapper.readValue(jsonWhile, HistoricalData.class);
                     }

                 }while(!(historicalData.getNext_page_token() == null));

                System.out.println("data saved");
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

    }
}
