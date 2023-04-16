package com.br.luminous.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
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
}
