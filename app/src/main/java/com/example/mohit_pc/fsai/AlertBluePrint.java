package com.example.mohit_pc.fsai;

public class AlertBluePrint {
    String message;
    String title;

    public AlertBluePrint(){

    }

    public AlertBluePrint(String message, String title) {
        this.message = message;
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public String getTitle() {
        return title;
    }
}
