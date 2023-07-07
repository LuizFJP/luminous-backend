package com.br.luminous.models;

import com.br.luminous.dto.WeatherTipDTO;
import com.br.luminous.entity.WeatherTip;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class WeatherTipResponse {
    private String description;
    private String city;
    private BigDecimal temperature;
    private BigDecimal feelsLike;
    private String tip;

    public WeatherTipResponse(WeatherTipDTO weatherTipDTO, String _tip) {
        description = weatherTipDTO.getDescription();
        city = weatherTipDTO.getCity();
        temperature = weatherTipDTO.getTemperature();
        feelsLike = weatherTipDTO.getFeelsLike();
        tip = _tip;
    }
}
