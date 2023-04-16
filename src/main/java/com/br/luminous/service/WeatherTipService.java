package com.br.luminous.service;

import com.br.luminous.entity.WeatherTips;
import com.br.luminous.enums.ClimateType;
import com.br.luminous.models.WeatherTipResponse;
import com.br.luminous.repository.UserRepository;
import com.br.luminous.repository.WeatherTipRepository;
import com.br.luminous.rest.weatherNotification.WeatherNotificationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jackson.JsonObjectSerializer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.List;

@RequiredArgsConstructor
@Service
public class WeatherTipService {
    private String uri = "https://pro.openweathermap.org/data/2.5/weather?lang=pt&weather&units=metric";

    @Value("${API_KEY_OPEN_WEATHER}")
    private String API_KEY;

    private final RestTemplate restTemplate;

    private final UserRepository userRepository;
    private final WeatherTipRepository weatherTipRepository;

    private final int SIXTEEN_DEGREES = 16;

    public WeatherTipResponse getTip(String email) {

//       var user = userRepository.findByEmail(email).orElseThrow(UserNotFoundException::new);
//       var city = user.getAddresses().get(0).getCity();
        var city = "Ibirama";
        uri += "&q=" + city + ",br" + "&APPID=" + API_KEY;

        ResponseEntity<WeatherNotificationResponse> response = restTemplate.getForEntity(uri, WeatherNotificationResponse.class);

        String description = response.getBody().getWeather().get(0).getDescription();
        BigDecimal temperature = response.getBody().getMain().getTemp();
        BigDecimal feelsLike = response.getBody().getMain().getFeelsLike();

        List<WeatherTips> weatherTips;
        if (temperature.compareTo(new BigDecimal(SIXTEEN_DEGREES)) >= 0) {
            weatherTips = weatherTipRepository.findAllWeatherTipsByClimate(ClimateType.HOT);
        } else {
            weatherTips = weatherTipRepository.findAllWeatherTipsByClimate(ClimateType.COLD);
        }

        var weatherTipResponse = new WeatherTipResponse(city, description, feelsLike, temperature, weatherTips);
        return weatherTipResponse;
    }
}
