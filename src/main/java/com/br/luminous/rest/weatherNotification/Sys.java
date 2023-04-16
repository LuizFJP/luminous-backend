package com.br.luminous.rest.weatherNotification;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Sys {
    @JsonProperty("type")
    private int type_;
    @JsonProperty("id")
    private BigDecimal id;
    @JsonProperty("country")
    private String country;
    @JsonProperty("sunrise")
    private BigDecimal sunrise;
    @JsonProperty("sunset")
    private BigDecimal sunset;
}
