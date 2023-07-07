package com.br.luminous.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@Table(name = "consumption")
public class Consumption {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private double energyConsumptionKWh;
    private double energyConsumptionReais;
    private LocalDate period;

    @ManyToOne
    @JoinColumn(name = "device_id", nullable = false)
    @JsonBackReference
    private Device device;

    public Consumption(double energyConsumptionKWh, Device device){
        this.energyConsumptionKWh = energyConsumptionKWh;
        this.device = device;
        this.energyConsumptionReais = energyConsumptionKWh * getTaxes();
        this.period = LocalDate.now();
    }

    private double getTaxes(){
        return device.getAddress().getEnergyProvider().getWhiteTax().getRegularPrice();
    }
}
