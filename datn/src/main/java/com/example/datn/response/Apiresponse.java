package com.example.datn.response;

import lombok.Data;

@Data
public class Apiresponse {
    private String message;
    public String getMessage() {
        return message;
    }

    // Setter
    public void setMessage(String message) {
        this.message = message;
    }
}
