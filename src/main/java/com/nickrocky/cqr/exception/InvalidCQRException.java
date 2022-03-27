package com.nickrocky.cqr.exception;

public class InvalidCQRException extends Exception{

    public InvalidCQRException(){
        super("The presented CQR Code was invalid due to malformed attributes.");
    }
}
