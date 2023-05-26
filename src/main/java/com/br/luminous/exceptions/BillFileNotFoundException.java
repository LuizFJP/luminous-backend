package com.br.luminous.exceptions;

public class BillFileNotFoundException extends RuntimeException{
    public BillFileNotFoundException(){
        super("Bill File was not found");
    }
}
