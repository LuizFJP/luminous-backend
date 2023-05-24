package com.br.luminous.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherTipDTO {
    private String description;
    private BigDecimal temperature;
    private BigDecimal feelsLike;
    private String city;
}
