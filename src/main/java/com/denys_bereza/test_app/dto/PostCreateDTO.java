package com.denys_bereza.test_app.dto;

import java.util.UUID;

public class PostCreateDTO {
    private UUID userID;
    private String text;

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
