package com.example.register.Controller;

import com.example.register.Request.Bank_request;
import com.example.register.Request.Bank_request2;
import com.example.register.Response.Bank_response;
import com.example.register.Response.Bank_responsepojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bank_url")
public class Bank_controller {
    @Autowired
    com.example.register.Service.Bank_service Bank_service;

    // api for credit
    @PostMapping("credit")
    public ResponseEntity<Bank_response> credit(@RequestBody Bank_request obj) {
        Bank_response res = new Bank_response();
        try {
            this.Bank_service.credit(obj);//call the service class method
            res.setMessage("Insert Successfully");
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            e.printStackTrace();//the response will print the consle page
            res.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(res);
        }
    }

    // api for debit
    @PostMapping("debit")
    public ResponseEntity<Bank_response> debit(@RequestBody Bank_request obj) {
        Bank_response res = new Bank_response();
        try {
            this.Bank_service.debit(obj);//call the service class method
            res.setMessage("Insert Successfully");
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            e.printStackTrace();//the response will print the consle page
            res.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(res);
        }
    }

    //
    @GetMapping("Bank")
    public ResponseEntity reg_user1() {
        return ResponseEntity.ok(this.Bank_service.getuserfromusertable());
    }

    @GetMapping("getbalance")
    public ResponseEntity getbalance() {
        try {
            return ResponseEntity.ok(this.Bank_service.getallBalance());
        } catch (Exception e) {
            Bank_response res = new Bank_response();
            res.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(res);
        }
    }

    @GetMapping("getcreditbalance")
    public ResponseEntity getcreditbalance() {
        try {
            return ResponseEntity.ok(this.Bank_service.creditbalance());
        } catch (Exception e) {
            Bank_response res = new Bank_response();
            res.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(res);
        }
    }

    @GetMapping("getdebitbalance")
    public ResponseEntity getdebitbalance() {
        try {
            return ResponseEntity.ok(this.Bank_service.debitbalance());
        } catch (Exception e) {
            Bank_response res = new Bank_response();
            res.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(res);
        }
    }

    @GetMapping("getbalancedetails")
    public ResponseEntity getbalancedetails() {
        try {
            Bank_responsepojo res = new Bank_responsepojo();
            //Bank_response res=new Bank_response();
            System.out.println("this is console " + this.Bank_service.creditbalance());
            res.setCredit(this.Bank_service.creditbalance());
            res.setDebit(this.Bank_service.debitbalance());
            res.setTotal(this.Bank_service.getallBalance());
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            Bank_response res = new Bank_response();
            // Bank_responsepojo res=new Bank_responsepojo();
            res.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(res);
        }
    }

    @GetMapping("updatebalance")
    public ResponseEntity updatebalance() {
        Bank_response res = new Bank_response();
        try {
            this.Bank_service.updatebalance();
            res.setMessage("update successfully");
            return ResponseEntity.ok(res);

        } catch (Exception e) {
            // e.printStackTrace();
            res.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(res);
        }
    }
    // annotation for id and
    @PostMapping("updateamount")
    public ResponseEntity updateamount(@RequestBody Bank_request2 bank_response2) {
        Bank_response res = new Bank_response();
        try {
          //  this.Bank_service.debit(obj);//call the service class method
            double updatebalance = this.Bank_service.updateamount(bank_response2.getId(),bank_response2.getAmount());
            res.setMessage("updatebalance : "+updatebalance);
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            // e.printStackTrace();
            res.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(res);
        }
    }
}

