package com.nickrocky.cqr.util;

public enum EncodingScheme {
    RESERVED, //000
    CHARACTER, //001
    CHARACTER_FULL, //010
    BYTE, //011
    BYTE_FULL, //100
    NUMBER, //101
    NUMBER_FULL, //110
    RESERVED_2; //111

    EncodingScheme(){

    }

    public static EncodingScheme getEncoding(PackageType type){
        EncodingScheme encodingScheme = RESERVED;
        switch (type){
            case BLACK -> encodingScheme = RESERVED;
            case YELLOW -> encodingScheme = CHARACTER;
            case MAGENTA -> encodingScheme = CHARACTER_FULL;
            case RED -> encodingScheme = BYTE;
            case CYAN -> encodingScheme = BYTE_FULL;
            case GREEN -> encodingScheme = NUMBER;
            case BLUE -> encodingScheme = NUMBER_FULL;
            case WHITE -> encodingScheme = RESERVED_2;
        }
        return encodingScheme;
    }
}
