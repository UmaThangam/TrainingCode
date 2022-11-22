package com.example.register.Service;
import com.example.register.Controller.People_controller;
import com.example.register.Model.People_model;
import com.example.register.Model.Transection_model;
import com.example.register.Repository.People_repo;
import com.example.register.Repository.Transection_repo;
import com.example.register.Request.Bank_request_amount;
import com.example.register.Request.Password_request;
import com.example.register.Request.People_pojo;
import com.example.register.Request.People_request;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class People_service {
    private static final Logger logger = LoggerFactory.getLogger(People_controller.class);
    @Autowired
    People_repo People_repo;
    @Autowired
    Transection_repo Transection_repo;

    // method for newregister with success and failure count
    public HashMap<String,Integer> newregister(List<People_request> obj) throws Exception {
        HashMap<String, Integer> hashMap = new HashMap<>();
        int success_count =0, failure_count =0;
        for (People_request iterator : obj) {
        Optional<People_model> p_model = this.People_repo.getuserbymail(iterator.getEmail());
            System.out.println(iterator.getPassword()+ " "+iterator.getEmail());
            if (iterator.getEmail().equals(" ")) {
                failure_count++;
                System.out.println("email is empty");
            }
            else if (iterator.getPassword().equals(" ")) {
                failure_count++;
                System.out.println("password is empty");
            }
            else if (iterator.getBalance().equals(" ")) {
                failure_count++;
                System.out.println("balance is empty");
            }
            else if(p_model.isPresent()) {
                failure_count++;
            }
           else {
                People_model people_model = new People_model();
                people_model.setEmail(iterator.getEmail()); //set the request email to people_model
                people_model.setPassword(iterator.getPassword());
                people_model.setBalance(iterator.getBalance());
                this.People_repo.save(people_model); // save the all data in repo
                success_count++;
                System.out.println("success"+success_count);
                }
            }
            hashMap.put("success_count", success_count);
            hashMap.put("failure_count", failure_count);

        return hashMap;
    }
    // method for login_check
    public boolean logincheck(String email, String password) throws  Exception{
        Optional<People_model> bank=this.People_repo.check(email, password); //call the repo method from service with optional datatype
        if(bank.isPresent()){
            throw new Exception("password can't be empty");
        }
        else
            throw new Exception("invalid login");
    }
    //token generate using pojo
    public People_pojo tokengenerate(People_request people_request) throws  Exception {
        if(people_request.getEmail().equals(" "))
            throw new Exception("email can't be empty");
        else if(people_request.getPassword().equals(" "))
            throw new Exception("password can't be empty");
        People_pojo people_pojo=new People_pojo();
        people_pojo.setToken(this.getToken2(people_request.getEmail()));
        people_pojo.setMessage("update successfully");
        return people_pojo;
    }
    public String getToken2(String email) {
        String token = email + System.currentTimeMillis();//adding the current time
        String res = Base64.getEncoder().encodeToString(token.getBytes());//convert string to bytes for encode
        return res;
    }
    // adding amount with specific id
    public double addamount(Bank_request_amount obj) throws Exception {
        Transection_model t_model=new Transection_model();
        Optional<People_model> obj2 = this.People_repo.findById(obj.getId());
       // People_model obj3 = this.People_repo.findById(obj.getId()).orElseThrow(()->new Exception("people not fount"));
        Double final_amount = null;
        if (obj.getId().equals(" "))
            throw new Exception("It can't be empty");
        else if (obj.getAmount() < 0)
            throw new Exception("amount can't be empty");
        else if (obj.getType().equals(" ")) {
            throw new Exception("Type can't be empty");
        }
         else if (obj2.isPresent()) {
            People_model model = obj2.get();
            System.out.println(obj.getType());
            if (obj.getType().equals("deposit"))
            {
                System.out.println(model.getBalance());
                System.out.println(model.getId()+""+model.getEmail()+""+model.getPassword());
                final_amount = model.getBalance() + obj.getAmount();
                System.out.println("the amount"+final_amount);
                this.People_repo.addbalance(final_amount, obj.getId());
            }
            if(obj.getType().equals("withdraw")){
                System.out.println("inside withdraw");
                if(model.getBalance()>obj.getAmount()){
                    final_amount = model.getBalance() - obj.getAmount();
                    System.out.println(model.getBalance()+""+obj.getAmount());
                    System.out.println("withdraw"+final_amount);
                    System.out.println("the amount"+final_amount);
                    this.People_repo.addbalance(final_amount, obj.getId());
                }
                else
                    throw new Exception("Your are having minimum balance,Can't withdraw");
            }
        }
         t_model.setUser_id(obj.getId());
         t_model.setAmount(obj.getAmount());
         t_model.setType(obj.getType());
        this.Transection_repo.save(t_model);
        return final_amount;
    }
    // update the password with specific id
    public boolean update_password(Password_request password_request) throws  Exception{
        People_model p_model = new People_model();
        Optional <People_model> obj = this.People_repo.findById(password_request.getUser_id());
            String final_password=null;
        if(password_request.getUser_id().equals(" "))
            throw new Exception("user_id can't be empty");
        else if(password_request.getOld_password().equals(" "))
            throw new Exception("old_password can't be empty");
        else if(password_request.getNew_password().equals(" "))
            throw new Exception("new_password can't be empty");
        else if(password_request.getConform_password().equals(" "))
            throw new Exception("new_password can't be empty");
        else if(obj.isPresent()){
            p_model= obj.get();
            if(password_request.getOld_password().equals(p_model.getPassword())){
                if(password_request.getNew_password().equals(password_request.getConform_password())){
                    this.People_repo.update_password(password_request.getConform_password(),password_request.getUser_id());
                }else
                    throw new Exception("new_password and confrom_password is not match");
            }else
                throw new Exception("password doesn't match with data_base password");
        }
        return true;
    }
    // register with email and password condition
    public HashMap<String, String> RegisterWithToken(String email, String password) throws  Exception {
        Optional<People_model> p_model = this.People_repo.check(email,password);
        People_model people_model=new People_model();
        HashMap<String, String> hashMap = new HashMap<>();
        String token= this.getToken(email);
        if(p_model.isPresent()){
            hashMap.put("message","email exit ,please provide proper email and password");
            hashMap.put("token"," ");
            return hashMap;
        }
        hashMap.put("message","update successfully");
        hashMap.put("success_token",token);
        people_model.setEmail(email);
        people_model.setPassword(password);
        people_model.setToken(token);
        this.People_repo.save(people_model);
        return hashMap;
    }
    public String getToken(String email){
        String token = email+System.currentTimeMillis();//adding the current time
        String res  = Base64.getEncoder().encodeToString(token.getBytes());//convert string to bytes for encode
        return res;
    }
    //method for login process
    public HashMap<String, String> login(String email, String password) throws  Exception {
        Optional<People_model> p_model = this.People_repo.login(email,password);
        HashMap<String, String> hashMap = new HashMap<>();
        if(p_model.isPresent()){
            People_model peopleModel=p_model.get();
            String newid=Integer.toString(peopleModel.getId());
            String token= this.getToken1(email,newid);
            hashMap.put("message","login successfull");
            hashMap.put("success_token",token);
            this.People_repo.loginupdate(token,p_model.get().getId());
            return hashMap;
        }
        hashMap.put("message","login failed");
        hashMap.put("token"," ");
        return hashMap;
    }
    public String getToken1(String email,String name){
        Calendar c = Calendar.getInstance(); // starts with today's date and time
        //c.add(Calendar.DAY_OF_YEAR, 1);  // advances day by 2
        c.add(Calendar.HOUR_OF_DAY, 1);
        Date date = c.getTime();
        String token = Jwts.builder().setSubject(name)
                .setIssuer(email)
                .setExpiration(date)
                // HMAC using SHA-512  and 12345678 base64 encoded
                .signWith(SignatureAlgorithm.HS512, "SECRET").compact();
        return token;
    }
    public Boolean decode(String token) throws Exception{
        try{
            Jws<Claims> jwt = Jwts.parser()
                    .setSigningKey("SECRET")
                    .parseClaimsJws(token);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
        return true;
    }
    // method for verify token
    public Boolean checkTokenForUserId(int Id,String token)throws Exception{
        People_repo.getTokenByUserId(Id,token).orElseThrow(()->new Exception("token is not valid"));
        return true;
    }

    public Boolean CheckTokenForUserId(String id2,String token)throws Exception{
        System.out.println(id2+" "+token);
        System.out.println("inside service method");
        if(token== null || token==""){
            System.out.println("inside if");
            throw new Exception("token is null");
        }
        else if(id2==null || id2==""){
            System.out.println("insdie else");
            throw new Exception("id is null");
        }
        System.out.println("else");
        int id3=Integer.parseInt(id2);
        People_repo.getTokenByUserId(id3,token).orElseThrow(()->new Exception("token is not valid"));
        return true;
    }
    // logout concept
    public Boolean userUpdateToken(Integer Id,String token ){
        try{
            People_repo.updateTokenByUserId(Id,token);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public void uploadPicture(String picture,Integer id)//file upload
    {
        try {
            People_repo.UpdateFileByUserId(id, picture);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String ReadImgById(Integer id) throws Exception{
        String imagename=this.People_repo.ReadImgById(id);
        logger.info("read image by id "+imagename);
        return imagename;
    }
}
