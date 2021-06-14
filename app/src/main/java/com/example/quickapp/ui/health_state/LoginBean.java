package com.example.quickapp.ui.health_state;

public class LoginBean {
    private int status;
    private String message;
    private String data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return data;
    }

    public void setToken(String token) {
        this.data = token;
    }
}
