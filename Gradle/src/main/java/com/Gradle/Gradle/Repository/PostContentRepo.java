package com.Gradle.Gradle.Repository;


import com.Gradle.Gradle.Model.PostContentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostContentRepo extends JpaRepository<PostContentModel,Integer> {

}
