package com.br.luminous.controller;

import com.br.luminous.entity.WeatherTips;
import com.br.luminous.models.WeatherTipResponse;
import com.br.luminous.service.WeatherTipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/weather-tip")
public class WeatherTipController {
    private final WeatherTipService weatherTipService;
    @GetMapping("/{id}")
    public ResponseEntity<WeatherTipResponse> getWeatherTip(Long id) {

        var response = weatherTipService.getTip(id);
        return new ResponseEntity<WeatherTipResponse>(response, HttpStatus.OK);
    }
}
