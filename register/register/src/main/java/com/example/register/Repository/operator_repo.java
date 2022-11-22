package com.example.register.Repository;

import com.example.register.Model.operator_model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface operator_repo extends JpaRepository<operator_model, Integer > {
}
