package com.trading.monster.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trading.monster.domain.AlpacaAsset;
import com.trading.monster.domain.CalendarDay;
import com.trading.monster.repositories.AlpacaAssetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class AlpacaAssetService {
    @Autowired
    AlpacaAssetRepository alpacaAssetRepository;

    public void saveAsset(AlpacaAsset asset){
        alpacaAssetRepository.save(asset);
    }

    public void getAssets(){
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.alpaca.markets/v2/assets?status=active&asset_class=us_equity"))
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
        List<AlpacaAsset> assets = null;
        try {
            assets = objectMapper.readValue(json, new TypeReference<List<AlpacaAsset>>(){});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        int i=0;
        for (AlpacaAsset asset: assets) {
            i++;
/*            if(i<3000){
                System.out.println(i+" "+asset.toString());
            }*/
            // added this assets by hand 3400 and 2066
            if((i!=3400)&(i!=2066)){
                System.out.println(i+" "+asset.toString());
                alpacaAssetRepository.save(asset);
            }
        }
        System.out.println(assets.size());
    }

}
