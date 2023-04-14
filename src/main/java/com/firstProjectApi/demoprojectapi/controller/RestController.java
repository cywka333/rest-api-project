package com.firstProjectApi.demoprojectapi.controller;

import com.firstProjectApi.demoprojectapi.dto.Root;
import com.firstProjectApi.demoprojectapi.service.ServiceForeignAPI;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
@RequiredArgsConstructor
public class RestController {

    private final ServiceForeignAPI serviceForeignAPI;

    @GetMapping("weather/current")
    public Root getCurrentWeather(@RequestParam("lat") String lat, @RequestParam("lon") String lon) {
        return serviceForeignAPI.getCurrentWeather(lat, lon);
    }
}
