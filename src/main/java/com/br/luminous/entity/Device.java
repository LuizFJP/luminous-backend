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
    private LocalTime usageTime;

    @ManyToOne
    @JoinColumn(name = "address_id", nullable = false)
    private Address adress;

    public Long getId() {
        return Id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }

    public LocalTime getUsageTime() {return usageTime;}

    public void setUsageTime(LocalTime usageTime) {
        this.usageTime = usageTime;
    }

    public Address getAdress(){return adress;}
}