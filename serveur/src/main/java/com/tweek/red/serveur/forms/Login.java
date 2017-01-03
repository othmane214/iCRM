package com.tweek.red.serveur.forms;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by tweek on 01/01/17.
 */
public class Login {
    @NotEmpty(message = "Please provide a valid login")
    private String login;
    @NotEmpty(message = "Please provide a valid password")
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
