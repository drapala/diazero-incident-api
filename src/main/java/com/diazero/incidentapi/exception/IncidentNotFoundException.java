package com.diazero.incidentapi.exception;

public class IncidentNotFoundException extends GenericException {

    public IncidentNotFoundException() {
        super("Incident not found.", 404);
    }

    public IncidentNotFoundException(String message) {
        super(message);
    }
}