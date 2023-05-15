package com.br.luminous.entity;

import com.br.luminous.DTO.EnergyProviderResponse;
import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "energyProvider")
public class EnergyProvider extends EnergyProviderResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="energyProvider_id")
    private Long id;

    private String name;

    private String urlMantaintenance;

    private String urlEnergyFall;
}


