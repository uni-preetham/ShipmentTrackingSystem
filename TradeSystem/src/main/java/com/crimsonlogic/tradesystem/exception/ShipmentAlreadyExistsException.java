package com.crimsonlogic.tradesystem.exception;

public class ShipmentAlreadyExistsException extends RuntimeException {
    public ShipmentAlreadyExistsException(String message) {
        super(message);
    }
}
