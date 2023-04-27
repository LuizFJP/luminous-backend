package com.br.luminous.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Tip")
public class Tip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String message;
}
