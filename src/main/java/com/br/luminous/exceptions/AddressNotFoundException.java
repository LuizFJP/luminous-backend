package com.br.luminous.exceptions;

public class AddressNotFoundException extends RuntimeException{

    public AddressNotFoundException() {
      super("Address not found.");
    }
}
