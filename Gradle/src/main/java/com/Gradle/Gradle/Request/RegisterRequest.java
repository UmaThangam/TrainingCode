package com.Gradle.Gradle.Request;

import com.sun.istack.NotNull;



public class RegisterRequest {

    @NotNull
//    @Size(min=2, max=30)
//    @NotBlank(message = "Email is mandatory")
    String email;

    //@NotBlank(message = "password is mandatory")
    String password;

   // @NotBlank(message = "Name is mandatory")
    String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    String role;
}
