package com.example.register.Repository;

import com.example.register.Model.City_model;
import com.example.register.Model.user_model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface user_repo extends JpaRepository <user_model, Integer>{
}
