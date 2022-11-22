package com.Gradle.Gradle.Repository;


import com.Gradle.Gradle.Model.BloggingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface BloggingRepo extends JpaRepository<BloggingModel,Integer> {
    @Query("select blogging from BloggingModel blogging where email = ?1 and password = ?2 ")//JPA Query
    Optional<BloggingModel> login(String  email, String password);

    @Modifying
    @Transactional
    @Query("update BloggingModel set token = ?1 where id=?2 ") // dynamic query
    void loginupdate(String token, Integer id);

    @Query("select um from BloggingModel um where um.id=?1 and um.token = ?2 ")
    Optional<BloggingModel> getTokenByUserId(Integer Id,String token);

    @Query("select um from BloggingModel um where um.id=?1")
    Optional<BloggingModel> GetRole(Integer Id);

    @Transactional
    @Modifying
    @Query("update BloggingModel um set  um.token=?2 where um.id=?1 ")
    void updateTokenByUserId(Integer Id,String token);

    @Modifying
    @Transactional
    @Query("update BloggingModel set password = ?1 where id = ?2 ") // dynamic query
    void update_password(String password , Integer id);

    @Transactional
    @Modifying
    @Query("update BloggingModel um set  um.picture=?2 where um.id=?1 ")
    void UpdateFileByUserId(Integer Id,String picture);
    @Query("select um.picture from BloggingModel um where um.id=?1 ")
    String ReadImgById(Integer userId);
}
