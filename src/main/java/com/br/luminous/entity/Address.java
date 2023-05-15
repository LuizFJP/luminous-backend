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
    @Column(name="address_id")
    private Long id;
    private String city;
    private String cep;
    private String road;
    private String neighborhood;
    private int houseNumber;
    private int inputVoltage;
    private String street;
    private String state;
    private String neighborhood;

    @OneToMany
    private List<Device> devices;

    @OneToMany
    private List<EnergyBill> energyBills;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
