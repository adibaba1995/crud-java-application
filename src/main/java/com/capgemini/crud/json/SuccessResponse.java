package com.capgemini.crud.json;

public class SuccessResponse {
    String message;

    public SuccessResponse() {
    }

    public SuccessResponse(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}