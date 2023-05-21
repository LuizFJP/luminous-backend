package com.br.luminous.enums;

public enum FlagType {
    GREEN_FLAG(0),
    YELLOW_FLAG(1),
    RED_FLAG_I(2),
    RED_FLAG_II(3);

    private int code;

    private FlagType(int code){
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public static FlagType valueOf(int code) {
        for (FlagType value : FlagType.values()) {
            if(value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }
}
