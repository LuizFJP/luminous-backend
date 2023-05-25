package com.br.luminous.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalTime;
import java.util.List;


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

    @OneToMany(cascade = CascadeType.ALL, mappedBy="device")
    @JsonManagedReference
    private List<Consumption> consumptionPerDay;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    @JsonBackReference
    private Address address;
}