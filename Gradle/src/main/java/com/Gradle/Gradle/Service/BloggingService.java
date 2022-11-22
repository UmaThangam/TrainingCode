package com.Gradle.Gradle.Service;


import com.Gradle.Gradle.Model.BloggingModel;
import com.Gradle.Gradle.Model.PersonDetailsModel;
import com.Gradle.Gradle.Model.PostContentModel;
import com.Gradle.Gradle.Repository.BloggingRepo;
import com.Gradle.Gradle.Repository.PersonDetailsRepo;
import com.Gradle.Gradle.Repository.PostContentRepo;
import com.Gradle.Gradle.Repository.RoleRepo;
import com.Gradle.Gradle.Request.LoginRequest;
import com.Gradle.Gradle.Request.Password_request;
import com.Gradle.Gradle.Request.RegisterRequest;
import com.Gradle.Gradle.Response.LoginResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

@Service
public class BloggingService {
    private static final Logger logger = LoggerFactory.getLogger(BloggingService.class);
    @Autowired
    BloggingRepo bloggingRepo;
    @Autowired
    PostContentRepo postContentRepo;
    @Autowired
    RoleRepo roleRepo;
    @Autowired
    Environment env;
    @Autowired
    EntityManager em;
    @Autowired
    PersonDetailsRepo personDetailsRepo;

    LoginResponse loginResponse=new LoginResponse();
    public Boolean Register(RegisterRequest request) throws Exception{
        BloggingModel bloggingModel=new BloggingModel();
            bloggingModel.setName(request.getName());
            bloggingModel.setEmail(request.getEmail());
            bloggingModel.setPassword(request.getPassword());
            this.bloggingRepo.save(bloggingModel);
        return true;
    }
    public LoginResponse Login(LoginRequest loginRequest) throws  Exception {
        logger.info("in service"+" "+loginRequest.getEmail()+" "+loginRequest.getPassword());
        Optional<BloggingModel> p_model = this.bloggingRepo.login(loginRequest.getEmail(), loginRequest.getPassword());
        if(p_model.isPresent()){
            logger.info("user is exit");
            BloggingModel bloggingModel= p_model.get();
            String newid=Integer.toString(bloggingModel.getId());
            String token1= this.GetToken(loginRequest.getEmail(),newid);
            this.bloggingRepo.loginupdate(token1,p_model.get().getId());
            loginResponse.setId(bloggingModel.getId());
            loginResponse.setName(bloggingModel.getName());
            loginResponse.setEmail(bloggingModel.getEmail());
            loginResponse.setToken(token1);
            loginResponse.setRole(bloggingModel.getRole());
            return loginResponse;
        }else{
            throw new Exception("no user fount");
        }
    }
    public String GetToken(String email,String name){
        Calendar c = Calendar.getInstance(); // starts with today's date and time
        c.add(Calendar.DAY_OF_YEAR, 1);  // advances day by 2
        //c.add(Calendar.MINUTE, 30);
        Date date = c.getTime();
        String token = Jwts.builder().setSubject(name)
                .setIssuer(email)
                .setExpiration(date)
                .signWith(SignatureAlgorithm.HS512, env.getProperty("JWT_TOKEN_SECRET")).compact();
        return token;
    }
    public Boolean Decode(String token) throws Exception{
        try{
            Jws<Claims> jwt = Jwts.parser()
                    .setSigningKey(env.getProperty("JWT_TOKEN_SECRET"))
                    .parseClaimsJws(token);
        }catch (Exception e){
            logger.error(e.getMessage());
            throw new Exception(e.getMessage());
        }
        return true;
    }
    public Boolean CheckTokenForUserId(String id2,String token)throws Exception{
        if(token== null || token==""){
            throw new Exception("token is null");
        }
        else if(id2==null || id2==""){
            throw new Exception("id is null");
        }
        this.Decode(token);
        int id3=Integer.parseInt(id2);
        bloggingRepo.getTokenByUserId(id3,token).orElseThrow(()->new Exception("token is not valid"));
        return true;
    }
    @Cacheable(cacheNames="user", key="#id")
    public BloggingModel GetDataFromTable(Integer id){
        logger.info("Cache method IN");
        Optional<BloggingModel> model=this.bloggingRepo.findById(id);
        BloggingModel bloggingModel=model.get();
        return bloggingModel;
    }
    public List<BloggingModel> GetAllData() {
        List<BloggingModel> list_obj = this.bloggingRepo.findAll(); //the final asnwer will be collection of list
        return list_obj;
    }
    public Boolean userUpdateToken(Integer Id,String token ){
        try{
            bloggingRepo.updateTokenByUserId(Id,token);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public boolean update_password(Password_request password_request) throws  Exception{
        logger.info("service");
        BloggingModel p_model = new BloggingModel();
        Integer id2=Integer.parseInt(password_request.getId());
        Optional <BloggingModel> obj = this.bloggingRepo.findById(id2);
        String final_password=null;
        if(password_request.getId().equals(" "))
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
                    this.bloggingRepo.update_password(password_request.getConform_password(),id2);
                }else
                    throw new Exception("new_password and confrom_password is not match");
            }else
                throw new Exception("password doesn't match with data_base password");
        }
        return true;
    }
    public void uploadPicture(String picture,Integer id)//file upload
    {
        try {
            bloggingRepo.UpdateFileByUserId(id, picture);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String ReadImgById(Integer id) throws Exception{
        String imagename=this.bloggingRepo.ReadImgById(id);
        logger.info("read image by id "+imagename);
        return imagename;
    }
}
