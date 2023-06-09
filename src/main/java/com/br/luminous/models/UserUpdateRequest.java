package com.br.luminous.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequest {
    private String name;
    private String phone;
    private String userName;
    private LocalDate birthdate;
    private String password;
}
