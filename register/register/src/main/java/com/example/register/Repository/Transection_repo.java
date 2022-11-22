package com.example.register.Repository;

import com.example.register.Model.Bank_model;
import com.example.register.Model.Transection_model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Transection_repo extends JpaRepository<Transection_model,Integer> {
}
