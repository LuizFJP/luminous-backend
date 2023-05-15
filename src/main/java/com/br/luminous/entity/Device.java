package com.br.luminous.entity;
import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Data
@Table(name ="device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;
    private float power;
    private LocalTime usageTime;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;
}