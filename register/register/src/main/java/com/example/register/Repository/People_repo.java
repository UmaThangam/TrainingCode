package com.example.register.Repository;

import com.example.register.Model.People_model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface People_repo extends JpaRepository<People_model,Integer> {

    @Query("select people from People_model people where email = ?1 and password = ?2 ")//JPA Query
    Optional<People_model> check(String  email,String password);

    @Modifying
    @Transactional
    @Query("update People_model set balance = ?1 where id = ?2 ") // dynamic query
    void addbalance(Double amount , Integer id);

    @Modifying
    @Transactional
    @Query("update People_model set password = ?1 where id = ?2 ") // dynamic query
    void update_password(String password , Integer id);

    //for email check
    @Query("select um from People_model um where email=?1 ")
    Optional<People_model>getuserbymail(String email);


    @Query("select people from People_model people where email = ?1 and password = ?2 ")//JPA Query
   Optional<People_model> login(String  email,String password);

    @Modifying
    @Transactional
    @Query("update People_model set token = ?1 where id=?2 ") // dynamic query
    void loginupdate(String token, Integer id);

    @Query("select um from People_model um where um.id=?1 and um.token = ?2 ")
    Optional<People_model> getTokenByUserId(Integer userId,String token);

    @Transactional
    @Modifying
    @Query("update People_model um set  um.token=?2 where um.id=?1 ")
    void updateTokenByUserId(Integer Id,String token);

    @Transactional
    @Modifying
    @Query("update People_model um set  um.picture=?2 where um.id=?1 ")
    void UpdateFileByUserId(Integer Id,String picture);


    @Query("select um.picture from People_model um where um.id=?1 ")
   String ReadImgById(Integer userId);


}
