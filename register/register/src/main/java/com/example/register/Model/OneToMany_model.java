package com.example.register.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="one_to_many")
public class OneToMany_model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    public List<Mobile_model> getMobile() {
        return obj;
    }

    public void setMobile(List<Mobile_model> mobile) {
        this.obj = mobile;
    }

    @OneToMany
    @JoinColumn(name = "user_id")
    List<Mobile_model> obj;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    String name,email,password,mobile_no;
}
