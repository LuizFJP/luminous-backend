package com.br.luminous.rest.weatherNotification;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Main {
    @JsonProperty("temp")
    private BigDecimal temp;
    @JsonProperty("feels_like")
    private BigDecimal feelsLike;
    @JsonProperty("temp_min")
    private BigDecimal tempMin;
    @JsonProperty("temp_max")
    private BigDecimal tempMax;
    @JsonProperty("pressure")
    private BigDecimal pressure;
    @JsonProperty("humidity")
    private BigDecimal humidity;
    @JsonProperty("sea_level")
    private BigDecimal seaLevel;
    @JsonProperty("grnd_level")
    private BigDecimal grndLevel;
}
