package com.example.register.Repository;

import com.example.register.Model.Mobile_model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Mobile_repo extends JpaRepository<Mobile_model,Integer> {

}
