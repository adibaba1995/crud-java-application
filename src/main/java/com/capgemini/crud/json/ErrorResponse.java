package com.capgemini.crud.json;

public class ErrorResponse {
    String error;

    public ErrorResponse() {
    }

    public ErrorResponse(String error) {
        super();
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}