package com.revature.spring_boot.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Credentials {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
