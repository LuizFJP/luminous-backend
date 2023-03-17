package com.br.luminous.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class UserResponse {
    private String name;
    private String phone;
    private String userName;
    private String email;
    private LocalDate birthDate;
}
