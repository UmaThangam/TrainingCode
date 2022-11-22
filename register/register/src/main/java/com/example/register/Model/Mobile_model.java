package com.example.register.Model;

import javax.persistence.*;

@Entity
@Table(name="Mobile")
public class Mobile_model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    String mobile_no,sim;
    Integer user_id;

}
