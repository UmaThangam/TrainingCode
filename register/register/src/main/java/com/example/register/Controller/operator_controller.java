package com.example.register.Controller;

import com.example.register.Request.operator_request;
import com.example.register.Response.operator_response;
import com.example.register.Service.operator_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("operator_url")
public class operator_controller {
        @Autowired
        com.example.register.Service.operator_service operator_service;

        @GetMapping("reg_user1")
         public ResponseEntity reg_user1(){
            return ResponseEntity.ok(this.operator_service.getuserfromusertable());
        }

        //store the value to database;
        @PostMapping("operator1")
        public ResponseEntity operator1(@RequestBody operator_request obj) {
            operator_response res = new operator_response(); //response class
            try {
                this.operator_service.Check(obj);//call the service class method
                res.setMessage("Insert Successfully");
                return ResponseEntity.ok(res);
            } catch (Exception e) {
                e.printStackTrace();//the response will print the consle page
                res.setMessage(e.getMessage());
                return ResponseEntity.badRequest().body(res);
            }
        }
}

