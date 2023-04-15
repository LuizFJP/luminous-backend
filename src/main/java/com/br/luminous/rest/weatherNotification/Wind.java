package com.br.luminous.rest.weatherNotification;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Wind {
    @JsonProperty("speed")
    private float speed;
    @JsonProperty("deg")
    private BigDecimal deg;
    @JsonProperty("gust")
    private float gust;
}
