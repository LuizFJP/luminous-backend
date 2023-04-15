package com.br.luminous.rest.weatherNotification;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Cloud {
    @JsonProperty("all")
    private int all;
}
