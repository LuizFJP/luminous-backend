package com.br.luminous.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tip")
public class Tip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "text")
    private String tipTitle;
    @Column(columnDefinition = "text")
    private String tipMessage;

}
