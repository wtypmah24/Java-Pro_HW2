package org.bank.validator.excemption;

public class WrongLengthException extends Exception{
    public WrongLengthException(String message) {
        super(message);
    }
}
