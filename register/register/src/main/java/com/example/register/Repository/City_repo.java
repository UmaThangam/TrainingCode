package com.example.register.Repository;

import com.example.register.Model.City_model;
import com.example.register.Model.user_model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface City_repo extends JpaRepository<City_model, Integer> {
    @Query("select c from City_model c where c.name=?1")
    Optional<City_model> getCityByName(String name);
}
