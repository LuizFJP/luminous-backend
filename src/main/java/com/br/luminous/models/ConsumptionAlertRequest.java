package com.br.luminous.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsumptionAlertRequest {
    private String descricao;

    private double consumptionLimit;

    private String consumptionAlertType;
}
