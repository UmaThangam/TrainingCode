package com.example.register.Request;

public class Password_request {
    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getOld_password() {
        return old_password;
    }

    public void setOld_password(String old_password) {
        this.old_password = old_password;
    }

    public String getNew_password() {
        return new_password;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }

    public String getConform_password() {
        return conform_password;
    }

    public void setConform_password(String conform_password) {
        this.conform_password = conform_password;
    }

    Integer user_id;
    String old_password,new_password,conform_password;
}
