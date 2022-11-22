package com.example.register.Service;

import com.example.register.Model.operator_model;
import com.example.register.Request.operator_request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class operator_service {
    @Autowired
    com.example.register.Repository.operator_repo operator_repo;

    public List<operator_model> getuserfromusertable() {
        List<operator_model> list_obj = this.operator_repo.findAll(); //the final asnwer will be collection of list
        return list_obj;
    }

    //service for operator controller
    public  boolean Check(operator_request obj)throws Exception{
        operator_model model_obj=new operator_model();
        int result=0;
        if (obj.getType().equals("add")) {
            result= obj.getNumber1() + obj.getNumber2();
        }
        else if (obj.getType().equals("sub")) {
             result= obj.getNumber1()- obj.getNumber2();
        }
        else if (obj.getType().equals("mul")) {
            result= obj.getNumber1()* obj.getNumber2();
        }
        else {
            throw new Exception("out of selection");
        }
        model_obj.setNumber1(obj.getNumber1()); // we are going to set the request value to model pojo in db
        model_obj.setNumber2(obj.getNumber2());
        model_obj.setResult(result);
        this.operator_repo.save(model_obj);
        return true;
    }


}
