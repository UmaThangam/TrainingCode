package com.example.register.Repository;

import com.example.register.Model.OneToMany_model;
import com.example.register.Model.user_model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OneToMany_repo extends JpaRepository<OneToMany_model,Integer> {

}
