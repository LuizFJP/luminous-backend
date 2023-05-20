package com.br.luminous.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JsonBackReference
    private Address address;
}