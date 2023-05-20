package com.br.luminous.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String cep;
    private int houseNumber;
    private int inputVoltage;
    private String street;
    private String state;
    private String neighborhood;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL)
    private List<Device> devices;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<EnergyBill> energyBills;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

}
