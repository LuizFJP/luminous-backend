package com.br.luminous.entity;

import lombok.Data;

import jakarta.persistence.*;


@Data
@Entity
@Table(name = "energy_provider")
public class EnergyProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="energy_provider_id")
    private Long id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "url_maintenance")
    private String urlMaintenance;
    @Column(name = "url_energy_fall")
    private String urlEnergyFall;
}
