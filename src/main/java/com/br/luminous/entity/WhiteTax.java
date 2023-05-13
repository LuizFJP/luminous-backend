package com.br.luminous.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "white_tax")
public class WhiteTax  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "regular_price")
    private float regularPrice;
    @Column(name = "low_price")
    private float lowPrice;
    @Column(name = "middle_price")
    private float middlePrice;
    @Column(name = "high_price")
    private float highPrice;
    @Column(name = "start_hour_low_price")
    private LocalTime startHourLowPrice;
    @Column(name = "end_hour_low_price")
    private LocalTime endHourLowPrice;
    @Column(name = "initial_start_hour_middle_price")
    private LocalTime initialStartHourMiddlePrice;
    @Column(name = "initial_end_hour_middle_price")
    private LocalTime initialEndHourMiddlePrice;
    @Column(name = "final_start_hour_middle_price")
    private LocalTime finalStartHourMiddlePrice;
    @Column(name = "final_end_hour_middle_price")
    private LocalTime finalEndHourMiddlePrice;
    @Column(name = "start_hour_high_price")
    private LocalTime startHourHighPrice;
    @Column(name = "end_hour_high_price")
    private LocalTime endHourHighPrice;
    @OneToOne
    @JoinColumn(name = "energy_provider_id")
    private EnergyProvider energyProvider;

}
