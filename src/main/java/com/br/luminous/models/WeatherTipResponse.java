package com.br.luminous.models;

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
    private List<WeatherTip> tips;
}
