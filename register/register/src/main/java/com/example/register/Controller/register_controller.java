package com.example.register.Controller;

import com.example.register.Model.user_model;
import com.example.register.Request.Mobile_request;
import com.example.register.Request.OneTwoMany_request;
import com.example.register.Request.register_request;
import com.example.register.Response.register_response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("register_url")
public class register_controller {
    private static final Logger logger = LoggerFactory.getLogger(People_controller.class);
    @Autowired
    com.example.register.Service.register_service register_service;

    //getting the datas from database
    @GetMapping("reg_user1")
    public ResponseEntity reg_user1(@RequestHeader String token){
        System.out.println("the token is :"+token);
        return ResponseEntity.ok(this.register_service.getuserfromusertable());
    }

    //store the data in data bases
    @PostMapping("store_user2")
    public ResponseEntity store_user2(@RequestBody List<register_request> reg){
        register_response res=new register_response();
        try{
            this.register_service.storeUsersCity(reg);
            res.setMessage("Insert Successfully");
            return ResponseEntity.ok(res);
        }catch (Exception e){
            e.printStackTrace();//one method of exception
            System.out.println(e);
           return ResponseEntity.badRequest().body(res);
        }
    }
    @PostMapping("OneToMany")
    public ResponseEntity OneToMany(@RequestBody OneTwoMany_request reg){
        register_response res=new register_response();
        try{
            logger.info("IN");
            res.setMessage("Insert Successfully");
            logger.info(String.valueOf(res));
            return ResponseEntity.ok(res);
        }catch (Exception e){
            logger.error("OUT");
            e.printStackTrace();//one method of exception
            System.out.println(e);
            return ResponseEntity.badRequest().body(res);
        }
    }
    @PostMapping("AddDataInMany")
    public ResponseEntity AddDataInMany(@RequestBody OneTwoMany_request oneTwoMany_request){
        register_response res=new register_response();
        try{
            logger.info("IN");
            this.register_service.adddatainmany(oneTwoMany_request);
            res.setMessage("Insert Successfully");
            logger.info(String.valueOf(res));
            return ResponseEntity.ok(res);
        }catch (Exception e){
            logger.error("OUT");
            e.printStackTrace();//one method of exception
            System.out.println(e);
            return ResponseEntity.badRequest().body(res);
        }
    }
    @PostMapping("AddDataInMobile")
    public ResponseEntity AddDataInMobile(@RequestBody Mobile_request mobile_request){
        register_response res=new register_response();
        try{
            logger.info("IN");
            this.register_service.adddatainmobile(mobile_request);
            res.setMessage("Insert Successfully");
            logger.info(String.valueOf(res));
            return ResponseEntity.ok(res);
        }catch (Exception e){
            logger.error(e.getMessage());
            res.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(res);
        }
    }
    @GetMapping("GetDataById/{id}")
    public ResponseEntity GetDataById(@PathVariable Integer id){
        logger.info("IN");
        return ResponseEntity.ok(this.register_service.getdatabyid(id));
    }
    @GetMapping("GetDataByIdMany/{id}")
    public ResponseEntity GetDataByIdMany(@PathVariable Integer id){
        logger.info("IN");
        return ResponseEntity.ok(this.register_service.getdatabyidmany(id));
    }
}
