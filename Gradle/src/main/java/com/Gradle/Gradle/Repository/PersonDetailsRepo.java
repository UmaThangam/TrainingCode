package com.Gradle.Gradle.Repository;


import com.Gradle.Gradle.Model.PersonDetailsModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDetailsRepo extends JpaRepository<PersonDetailsModel,Integer> {
    @Query(" select count(name) from PersonDetailsModel ")//JPA Query
    Integer DataCount();


}
