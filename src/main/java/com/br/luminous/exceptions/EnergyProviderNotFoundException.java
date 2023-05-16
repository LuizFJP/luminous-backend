package com.br.luminous.exceptions;

public class EnergyProviderNotFoundException extends RuntimeException{

    public EnergyProviderNotFoundException() {
        super("EnergyProvider not found.");
    }
}