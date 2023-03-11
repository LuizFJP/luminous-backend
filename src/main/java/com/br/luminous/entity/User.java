package com.br.luminous.entity;

import lombok.Data;


import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String phone;
    private String userName;
    private String email;
    private String password;
    private LocalDate birthDate;
}
