package com.diazero.incidentapi.exception;

public class IncidentAlreadyExistsException extends GenericException {

    public IncidentAlreadyExistsException() {
        super("Incident already exists.", 409);
    }

    public IncidentAlreadyExistsException(String message) {
        super(message);
    }
}