package com.br.luminous.entity;

import com.br.luminous.enums.ConsumptionAlertType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "consumption_alert")
public class ConsumptionAlert {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String descricao;

    private double consumptionLimit;

    @Enumerated(EnumType.STRING)
    private ConsumptionAlertType consumptionAlertType;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = true)
    @JsonBackReference
    private Address address;
}
