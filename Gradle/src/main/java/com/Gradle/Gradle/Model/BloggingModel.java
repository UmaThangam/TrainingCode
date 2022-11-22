package com.Gradle.Gradle.Model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "blogging")
public class BloggingModel {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    public List<PostContentModel> getPostContentModelList() {
        return postContentModelList;
    }

    public void setPostContentModelList(List<PostContentModel> postContentModelList) {
        this.postContentModelList = postContentModelList;
    }

    @OneToMany
    @JoinColumn(name = "user_id")
    List<PostContentModel> postContentModelList;

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

    String name;
    String email;
    String password;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    String picture;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    String token;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    String role;

}
