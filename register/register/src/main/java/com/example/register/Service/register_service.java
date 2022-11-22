package com.example.register.Service;

import com.example.register.Controller.People_controller;
import com.example.register.Model.*;
import com.example.register.Repository.City_repo;
import com.example.register.Repository.Mobile_repo;
import com.example.register.Repository.OneToMany_repo;
import com.example.register.Request.Mobile_request;
import com.example.register.Request.OneTwoMany_request;
import com.example.register.Request.register_request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class register_service {
    private static final Logger logger = LoggerFactory.getLogger(People_controller.class);
    @Autowired
    com.example.register.Repository.user_repo user_repo;
    @Autowired
    City_repo city_repo;
    @Autowired
    OneToMany_repo oneToMany_repo;
    @Autowired
    Mobile_repo mobile_repo;
    //getting data from user table
    public List<user_model> getuserfromusertable() {
        List<user_model> list_obj = this.user_repo.findAll(); //the final asnwer will be collection of list
        return list_obj;
    }
    //store the data in user table
    public boolean storeuser(register_request obj ) throws Exception {
        Optional<City_model> city_model=this.city_repo.getCityByName(obj.getCity_name());
        user_model user_obj = new user_model();
           if(!city_model.isPresent()) {
               throw new Exception("invalid city name");
           }
         else if (obj.getEmail().equals("")) {
            throw new Exception("email cant be empty");
        } else if (obj.getPassword().equals("")) {
            throw new Exception("password cant be empty");
        } else if (obj.getName().equals("")) {
            throw new Exception("name cant be empty");
        } else {
            user_obj.setEmail(obj.getEmail());
            user_obj.setPassword(obj.getPassword());
            user_obj.setName(obj.getName());
            user_obj.setCity(city_model.get());
            this.user_repo.save(user_obj);
        }
        return true;
    }
    //storing  multiple data in user table
    public Boolean storeUsersCity(List<register_request> req) {
        try {
            List<user_model> List = new ArrayList<user_model>();
            req.stream().forEach(r -> {
                        try {
                            user_model userModel = new user_model();
                            City_model citymodel= createOrReturnCity(r.getCity_name());
                            userModel.setCity(citymodel);
                            userModel.setName(r.getName());
                            userModel.setEmail(r.getEmail());
                            userModel.setPassword(r.getPassword());
                            List.add(userModel);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    });
            System.out.println(List.size() + "going to insert");
            user_repo.saveAll(List);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return true;
    }
    //storing  data in one_to_many table
    public boolean adddatainmany(OneTwoMany_request obj ) throws Exception {
        OneToMany_model oneToManyModel = new OneToMany_model();
        if (obj.getEmail().equals("")) {
            throw new Exception("email cant be empty");
        } else if (obj.getName().equals("")) {
            throw new Exception("name cant be empty");
        } else if (obj.getPassword().equals("")) {
            throw new Exception("sim cant be empty");
        } else if (obj.getMobile_no().equals("")) {
            throw new Exception("mobile_no cant be empty");
        }else {
            oneToManyModel.setMobile_no(obj.getMobile_no());
            oneToManyModel.setName(obj.getName());
            oneToManyModel.setPassword(obj.getPassword());
            oneToManyModel.setEmail(obj.getEmail());
            this.oneToMany_repo.save(oneToManyModel);
        }
        return true;
    }
    //storing data in mobile table
    public boolean adddatainmobile(Mobile_request obj ) throws Exception {
        Optional<OneToMany_model> oneToMany_model=this.oneToMany_repo.findById(obj.getUser_id());
        if(!oneToMany_model.isPresent()){
            throw new Exception("user id is not found");
        }
        Mobile_model mobileModel = new Mobile_model();
        if (obj.getMobile_no().equals("")) {
            throw new Exception("mobile_no cant be empty");
        } else if (obj.getUser_id().equals("")) {
            throw new Exception("user_id cant be empty");
        } else if (obj.getSim().equals("")) {
            throw new Exception("sim cant be empty");
        } else {
                mobileModel.setMobile_no(obj.getMobile_no());
                mobileModel.setUser_id(obj.getUser_id());
                mobileModel.setSim(obj.getSim());
                this.mobile_repo.save(mobileModel);
        }
        return true;
    }
    private City_model createOrReturnCity(String name) throws Exception{
        Optional<City_model> citymodel=city_repo.getCityByName(name);
        if(citymodel.isPresent()){
            return citymodel.get();
        }else{
            City_model city = new City_model();
            city.setName(name);
            city_repo.save(city);
            return city;
        }
    }
    // getting data from user table by using id
        public user_model getdatabyid(Integer id){
        Optional<user_model> userModel=this.user_repo.findById(id);
            user_model u_model=userModel.get();
            return u_model;
        }
     //getting data from one_to_many table using id
    public OneToMany_model getdatabyidmany(Integer id){
        Optional<OneToMany_model> model=this.oneToMany_repo.findById(id);
        OneToMany_model oneToManyModel=model.get();
        return oneToManyModel;
    }
}
