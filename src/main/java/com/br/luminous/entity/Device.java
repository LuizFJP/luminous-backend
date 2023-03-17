package com.br.luminous.entity;
import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name ="devices")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String name;
    private float power;
    private String usage_time;
    private String category;

}