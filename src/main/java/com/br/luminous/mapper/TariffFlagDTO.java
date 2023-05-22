package com.br.luminous.mapper;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
@NoArgsConstructor
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class TariffFlagDTO {

    @JsonProperty("id")
    private long id;
    @JsonProperty("flagType")
    private int FlagType;

    @JsonProperty("month")
    private LocalDateTime month;

    @JsonProperty("value")
    private float value;
    /*
{
    “id”: 23,
    “flagType”: 0,
    “month”: “2019-01-01T00:00:00”,
    “value”: 0
}

  */
}
