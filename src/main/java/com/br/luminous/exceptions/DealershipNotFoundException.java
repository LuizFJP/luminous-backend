package com.br.luminous.exceptions;

public class DealershipNotFoundException extends RuntimeException{

    public DealershipNotFoundException() {
        super("ealership not found.");
    }
}
