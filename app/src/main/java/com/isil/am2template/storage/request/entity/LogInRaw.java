package com.isil.am2template.storage.request.entity;

/**
 * Created by AndresCyTz on 24/11/2017.
 */

/*
{
  "login":"acaycho@mail.com",
  "password":"123456"
}
 */
public class LogInRaw {

    private String login;
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
