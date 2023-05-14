package com.br.luminous.entity;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "dealership")
public class Dealership {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String urlMaintain;

    private String urlEnergyFall;

  // NÃO PRECISA  private String cnpj;
}

/* Concessionária (Dealership)
*
* */
