package com.br.luminous.exceptions;

public class TipNotFoundException extends RuntimeException{
    public TipNotFoundException(){
        super("Tip not found.");
    }
}
