package com.br.luminous.entity;

import lombok.Data;

import jakarta.persistence.*;

import java.util.List;

@Data
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String cep;
    private String road;
    private String neighborhood;
    private int houseNumber;
    private int inputVoltage;

    @OneToMany
    private List<Device> devices;

    @OneToMany
    private List<EnergyBill> energyBills;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

}
