package com.example.register.Request;

// we are checking giving email and passord is present or not
public class People_request2 { // this pojo for login check .because we r going to pass two args in post man
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String email,password;
}
