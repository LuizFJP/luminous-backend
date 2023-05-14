package com.br.luminous.entity;
import lombok.Data;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Data
@Table(name ="devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;
    private float power;
    private LocalTime usage_time;

}