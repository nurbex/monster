import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trading.monster.domain.CalendarDay;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetCalendar {
    public static void main(String[] args) {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.alpaca.markets/v2/calendar"))
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
        List<CalendarDay> calendar = null;
        try {
            calendar = objectMapper.readValue(json, new TypeReference<List<CalendarDay>>(){});
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(calendar.size());
    }
}
