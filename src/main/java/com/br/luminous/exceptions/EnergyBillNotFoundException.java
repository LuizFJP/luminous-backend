package com.br.luminous.exceptions;

public class EnergyBillNotFoundException extends RuntimeException{
    public EnergyBillNotFoundException(){
        super("EnergyBill not found");
    }
}
