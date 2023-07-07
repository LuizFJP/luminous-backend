package com.br.luminous.models;

import com.br.luminous.entity.EnergyProvider;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WhiteTaxResponse {
    private float regularPrice;
    private float lowPrice;
    private float middlePrice;
    private float highPrice;
    @JsonFormat(pattern="HH:mm")
    private LocalTime startHourLowPrice;
    @JsonFormat(pattern="HH:mm")
    private LocalTime endHourLowPrice;
    @JsonFormat(pattern="HH:mm")
    private LocalTime initialStartHourMiddlePrice;
    @JsonFormat(pattern="HH:mm")
    private LocalTime initialEndHourMiddlePrice;
    @JsonFormat(pattern="HH:mm")
    private LocalTime finalStartHourMiddlePrice;
    @JsonFormat(pattern="HH:mm")
    private LocalTime finalEndHourMiddlePrice;
    @JsonFormat(pattern="HH:mm")
    private LocalTime startHourHighPrice;
    @JsonFormat(pattern="HH:mm")
    private LocalTime endHourHighPrice;
    @JsonFormat(pattern="HH:mm")
    private float save;
    private EnergyProvider energyProvider;
}
