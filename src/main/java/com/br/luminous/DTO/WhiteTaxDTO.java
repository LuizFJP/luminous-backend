package com.br.luminous.DTO;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WhiteTaxDTO {
    private String companyName;
    @Column(name = "regular_price")
    private float regularPrice;
    @Column(name = "low_price")
    private float lowPrice;
    private float middlePrice;
    private float highPrice;
    private LocalTime startHourLowPrice;
    private LocalTime endHourLowPrice;
    private LocalTime initialStartHourMiddlePrice;
    private LocalTime initialEndHourMiddlePrice;
    private LocalTime finalStartHourMiddlePrice;
    private LocalTime finalEndHourMiddlePrice;
    private LocalTime startHourHighPrice;
    private LocalTime endHourHighPrice;
    private float save;
}
