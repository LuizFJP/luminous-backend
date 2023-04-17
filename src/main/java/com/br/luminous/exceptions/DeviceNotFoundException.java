package com.br.luminous.exceptions;

public class DeviceNotFoundException extends RuntimeException {

    public DeviceNotFoundException() {
        super("Device not found");
    }
}
