package com.br.luminous.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "residences")
public class Residence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int cep;
    private int houseNumber;
    private int inputVoltage;

}

/*inputVoltage (tensão de entrada)
* tensão de entrada da rede elétrica: 110v ou 220v */
