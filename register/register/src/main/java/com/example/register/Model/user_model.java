package com.example.register.Model;

import javax.persistence.*;

@Entity
@Table(name="user")
public class user_model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    public City_model getCity() {
        return city;
    }

    public void setCity(City_model city) {
        this.city = city;
    }

    @OneToOne
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    City_model city;

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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getId() {
        return id;
    }
    String email;
    String password;
    String name;
}
