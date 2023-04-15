package com.br.luminous.rest.weatherNotification;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Data
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class WeatherNotificationResponse {
    @JsonProperty("coord")
    private Coord coord;
    @JsonProperty("weather")
    private List<Weather> weather;
    @JsonProperty("base")
    private String base;
    @JsonProperty("main")
    private Main main;
    @JsonProperty("visibility")
    private BigDecimal visibility;
    @JsonProperty("wind")
    private Wind wind;
    @JsonProperty("clouds")
    private Cloud cloud;
    @JsonProperty("dt")
    private BigDecimal dt;
    @JsonProperty("sys")
    private Sys sys;
    @JsonProperty("timezone")
    private BigDecimal timezone;
    @JsonProperty("id")
    private BigDecimal id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("cod")
    private int cod;
}
