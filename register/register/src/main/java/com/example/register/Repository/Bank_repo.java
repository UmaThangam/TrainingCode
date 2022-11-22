package com.example.register.Repository;

import com.example.register.Model.Bank_model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface Bank_repo extends JpaRepository<Bank_model,Integer> {
    // (select alise_namw from model_name alice_name where colum_name=' ')
    @Query("select bankmodel from Bank_model bankmodel where type='credit'")//JPA Query
    List<Bank_model> getCreditData();

    @Query("select bankmodel from Bank_model bankmodel where type='debit'")//JPA Query
    List<Bank_model> getdebittData();

    @Modifying
    @Transactional
    @Query("update Bank_model set amount = 2390 where id = 4")
    void updatebalance();

    @Modifying
    @Transactional
    @Query("update Bank_model set amount = ?1 where id = ?2 ") // dynamic query
    void updatebalance1(Double amount , Integer id);
}
