package com.br.luminous.service;

import com.br.luminous.dto.WeatherTipDTO;
import com.br.luminous.entity.User;
import com.br.luminous.entity.WeatherTip;
import com.br.luminous.enums.ClimateType;
import com.br.luminous.models.WeatherTipResponse;
import com.br.luminous.repository.UserRepository;
import com.br.luminous.repository.WeatherTipRepository;
import com.br.luminous.rest.weatherNotification.WeatherNotificationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.*;

@RequiredArgsConstructor
@Service
public class WeatherTipService {
    private String uri = "https://pro.openweathermap.org/data/2.5/weather?lang=pt&weather&units=metric";

    @Value("${API_KEY_OPEN_WEATHER}")
    private String API_KEY;

    private final RestTemplate restTemplate;

    private final UserService userService;
    private final WeatherTipRepository weatherTipRepository;
    private final UserRepository userRepository;

    private final int SIXTEEN_DEGREES = 16;

    public WeatherTipResponse getTip(Long id) {

        var user = userService.getUserById(id);
        var weatherDTO = requestWeatherAPI(user);

        ClimateType climate = setClimateByTemperature(weatherDTO.getTemperature());
        WeatherTip weatherTip;

        Optional<List<WeatherTip>> weatherReadTips = weatherTipRepository.findAllByUsers(user);
        if (weatherReadTips.isPresent()) {
            Set<Long> ids = new HashSet<>();
            for (WeatherTip tip : user.getWeatherTips()) {
                ids.add(tip.getId());
            }
            var weatherTips = weatherTipRepository.findByClimateAndIdNotIn(climate, ids);

            try {
                weatherTip = getTipByList(weatherTips, user);
            } catch (IndexOutOfBoundsException outOfBoundsException) {
                deleteAllReadWeatherByTips(user);
                weatherTip = getTipByClimate(climate, user);
            }
        } else {
            weatherTip = getTipByClimate(climate, user);
        }
        var weatherTipResponse = new WeatherTipResponse(weatherDTO, weatherTip.getTip());

        return weatherTipResponse;
    }

    private WeatherTipDTO requestWeatherAPI(User user) {
        var city = user.getAddresses().get(0).getCity();
        uri += "&q=" + city + ",br" + "&APPID=" + API_KEY;

        ResponseEntity<WeatherNotificationResponse> response = restTemplate.getForEntity(uri, WeatherNotificationResponse.class);

        String description = response.getBody().getWeather().get(0).getDescription();
        BigDecimal temperature = response.getBody().getMain().getTemp();
        BigDecimal feelsLike = response.getBody().getMain().getFeelsLike();

        return new WeatherTipDTO(description, temperature, feelsLike, city);
    }

    private WeatherTip getTipByClimate(ClimateType climate, User user) {
        var tip = getFirstTip(climate);
        saveUserReadWeatherTip(tip, user);
        return tip;
    }

    private WeatherTip getTipByList(List<WeatherTip> weatherTips, User user) {
        var tip = getFirstTip(weatherTips);
        saveUserReadWeatherTip(tip, user);
        return tip;
    }

    private ClimateType setClimateByTemperature(BigDecimal temperature) {
        return  isHot(temperature)
                ? ClimateType.HOT
                : ClimateType.COLD;
    }

    private boolean isHot(BigDecimal temperature) {
        return (temperature.compareTo(new BigDecimal(SIXTEEN_DEGREES)) >= 0);
    }

    private void saveUserReadWeatherTip(WeatherTip weatherTip, User user) {
        var userWeatherTips = user.getWeatherTips();
        userWeatherTips.add(weatherTip);
        user.setWeatherTips(userWeatherTips);
        userRepository.save(user);
    }

    private void deleteAllReadWeatherByTips(User user) {
        user.setWeatherTips(new ArrayList<>());
        userRepository.save(user);
    }
    private WeatherTip getFirstTip(ClimateType climate) {
        var allWeatherTipsByClimate = weatherTipRepository.findAllWeatherTipsByClimate(climate);
        return allWeatherTipsByClimate.get(0);
    }

    private WeatherTip getFirstTip(List<WeatherTip> weatherTips) {
        return weatherTips.get(0);
    }
}
