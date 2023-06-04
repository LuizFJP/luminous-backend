package com.br.luminous.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateResponse {
    private String name;
    private String phone;
    private String userName;
    private String email;
    private LocalDate birthdate;
}
