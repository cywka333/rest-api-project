package com.firstProjectApi.demoprojectapi.service;

import com.firstProjectApi.demoprojectapi.dto.Root;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ServiceForeignAPI {

    private final RestTemplate restTemplate;
    @Value("${openweather.url}")
    private String URL;
    @Value("${api.key}")
    private String API_KEY;
    private Logger log = LoggerFactory.getLogger(ServiceForeignAPI.class);

    public Root getCurrentWeather(String lat, String lon) {
        String requestUrl = URL + lat + "&lon=" + lon + "&appid=" + API_KEY;
        log.info("Passed values for lat: " + lat + ", lon = " + lon);
        log.info("request url is: " + requestUrl);
        ResponseEntity<Root> forEntity = restTemplate.getForEntity(requestUrl, Root.class);
        log.info("Response status: " + forEntity.getStatusCode());
        return forEntity.getBody();
    }
    @PostConstruct
    void run(){
        getCurrentWeather("50", "50");
    }
}
