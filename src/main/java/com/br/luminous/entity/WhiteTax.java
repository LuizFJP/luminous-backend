package com.br.luminous.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "white_taxes")
public class WhiteTax  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "regular_price")
    private String regularPrice;
    @Column(name = "low_price")
    private String lowPrice;
    @Column(name = "middle_price")
    private String middlePrice;
    @Column(name = "high_price")
    private String highPrice;
    @Column(name = "start_hour_low_price", columnDefinition = "TIME")
    private LocalTime startHourLowPrice;
    @Column(name = "end_hour_low_price", columnDefinition = "TIME")
    private LocalTime endHourLowPrice;
    @Column(name = "initial_start_hour_middle_price", columnDefinition = "TIME")
    private LocalTime initialStartHourMiddlePrice;
    @Column(name = "initial_end_hour_middle_price", columnDefinition = "TIME")
    private LocalTime initialEndHourMiddlePrice;
    @Column(name = "final_start_hour_middle_price", columnDefinition = "TIME")
    private LocalTime finalStartHourMiddlePrice;
    @Column(name = "final_end_hour_middle_price", columnDefinition = "TIME")
    private LocalTime finalEndHourMiddlePrice;
    @Column(name = "start_hour_high_price", columnDefinition = "TIME")
    private LocalTime startHourHighPrice;
    @Column(name = "end_hour_high_price", columnDefinition = "TIME")
    private LocalTime endHourHighPrice;

}
