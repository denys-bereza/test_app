package com.denys_bereza.test_app.dto;

import com.denys_bereza.test_app.constants.Regions;

public class UserDTO {
    private String name;
    private String email;
    private Regions region;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Regions getRegion() {
        return region;
    }

    public void setRegion(Regions region) {
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
