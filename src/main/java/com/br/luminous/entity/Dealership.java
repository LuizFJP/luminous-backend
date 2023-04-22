package com.br.luminous.entity;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "dealerships")
public class Dealership {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String urlMantain;

    private String urlEnergyFall;

  // NÃO PRECISA  private String cnpj;
}

/* Concessionária (Dealership)
*
* */
