package com.Gradle.Gradle.Repository;


import com.Gradle.Gradle.Model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<RoleModel,Integer> {
    @Query("select role_temp from RoleModel role_temp where method_name = ?1 and role = ?2 ")//JPA Query
    Optional<RoleModel> CheckRole(String  method_name, String role);
}
