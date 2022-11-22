package com.example.register.Controller;
import com.example.register.Request.*;
import com.example.register.Response.Bank_response;
import com.example.register.Response.People_response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.IOUtils;

@RestController
@RequestMapping("people_url")
public class People_controller {

    String UPLOADED_FOLDER="C:\\Users\\10592\\Uploadfile\\";
    private static final Logger logger = LoggerFactory.getLogger(People_controller.class);
    @Autowired
    com.example.register.Service.People_service People_service;

    //annotation for people register
    @PostMapping("newregister")
    public ResponseEntity newregister(@RequestBody List<People_request> people_request) {
        logger.info("IN");
        People_response people_response = new People_response();
        try {
            logger.info("IN");
            HashMap<String, Integer> resobj = this.People_service.newregister(people_request);
            //people_response.setMessage("stored successfully");
            logger.info("OUT");
            return ResponseEntity.ok(resobj);

        } catch (Exception e) {
            e.printStackTrace();
            people_response.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(people_response);
        }
    }

    //annotation for login
    @PostMapping("login")
    public ResponseEntity login(@RequestBody People_request2 people_request2) {
        People_response people_response = new People_response();
        try {
            this.People_service.logincheck(people_request2.getEmail(), people_request2.getPassword()); //call the service method with 2 args
            people_response.setMessage("Insert Successfully");
            people_response.setMessage(people_response.getMessage());
            return ResponseEntity.ok(people_response);
        } catch (Exception e) {
            e.printStackTrace();
            people_response.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(people_response);
        }
    }

    @PostMapping("bank")
    public ResponseEntity bank(@RequestBody Bank_request_amount bank_request) {
        People_response res = new People_response();
        try {
            System.out.println(bank_request.getType());
            this.People_service.addamount(bank_request);//call the service class method

            res.setMessage("Addedd Successfully");
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            e.printStackTrace();//the response will print the consle page
            res.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(res);
        }
    }

    // annotation for update the password
    @PostMapping("password")
    public ResponseEntity password(@RequestBody Password_request obj) {
        People_response res = new People_response();
        try {
            this.People_service.update_password(obj);//call the service class method

            res.setMessage("Updated Successfully");
            return ResponseEntity.ok(res);
        } catch (Exception e) {
            e.printStackTrace();//the response will print the consle page
            res.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(res);
        }
    }

    @PostMapping("tokenpojo")
    public ResponseEntity tokenpojo(@RequestBody People_request obj) {
        People_response res = new People_response();
        try {
            People_pojo resobj = this.People_service.tokengenerate(obj);//call the service class method
            //res.setMessage("Updated Successfully");
            return ResponseEntity.ok(resobj);
        } catch (Exception e) {
            e.printStackTrace(); //the response will print the consle page
            res.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(res);
        }
    }

    //register api
    @PostMapping("register_withtoken")
    public ResponseEntity register_withtoken(@RequestBody People_request2 people_request2) {
        People_response res = new People_response();
        try {
            HashMap<String, String> resobj = this.People_service.RegisterWithToken(people_request2.getEmail(), people_request2.getPassword());//call the service class method
            res.setMessage("Updated Successfully");
            return ResponseEntity.ok(resobj);
        } catch (Exception e) {
            e.printStackTrace(); //the response will print the consle page
            res.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(res);
        }
    }
    //login api
    @PostMapping("logincheck")
    public ResponseEntity logincheck(@RequestBody People_request2 people_request2) {
        People_response res = new People_response();
        try {
            HashMap<String, String> resobj = this.People_service.login(people_request2.getEmail(), people_request2.getPassword());//call the service class method
            res.setMessage("Updated Successfully");
            return ResponseEntity.ok(resobj);
        } catch (Exception e) {
            e.printStackTrace(); //the response will print the consle page
            res.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(res);
        }
    }
    @PostMapping("checkidtoken")
    public ResponseEntity checkcidtoken(@RequestHeader String token,@RequestHeader Integer id){
        logger.info("IN");
        try{
            logger.info("OUT");
            People_service.checkTokenForUserId(id,token);
            return ResponseEntity.ok("success flow");
        }catch (Exception e){
            logger.error("error");
            return  ResponseEntity.badRequest().body(e.getMessage());//response with obj

        }
    }

    @PostMapping("Logout/{id}")
    public ResponseEntity logout(@PathVariable Integer id ){
        People_service.userUpdateToken(id,"");
        return ResponseEntity.ok("logout success");
    }

    @PostMapping("LogoutUseToken")
    public ResponseEntity logoutusetoken(){
        System.out.println("in controller");
       // People_service.userUpdateToken(id,"");
        return ResponseEntity.ok("logout success");
    }
    @PostMapping("uploadFile")
    public ResponseEntity uploadFile(@RequestParam MultipartFile file,@RequestParam Integer Id){
        try{
            String fileName = file.getOriginalFilename();
            String folderWithName = UPLOADED_FOLDER+fileName;
            Path path = Paths.get(folderWithName);//set path with filename
//            File f = new File(""+UPLOADED_FOLDER+fileName);
//            if(f.exists()){
//                fileName = fileName+"(1)";
//                path = Paths.get(UPLOADED_FOLDER +fileName);//set path with filename
//            }
            Files.write(path, file.getBytes());//write the file in the locatio
            People_service.uploadPicture(fileName,Id);
            return ResponseEntity.ok("upload success "+file.getOriginalFilename());//return the file name
        }catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());//response with obj
        }
    }
    @PostMapping("uploadMutliFile")
    public ResponseEntity uploadFiles(@RequestParam MultipartFile[] file,@RequestParam Integer Id){
        try{
            for(MultipartFile f:file){
                String fileName = f.getOriginalFilename();
                String folderWithName = UPLOADED_FOLDER+fileName;
                Path path = Paths.get(folderWithName);//set path with filename
               Files.write(path, f.getBytes());//write the file in the location
            }
            return ResponseEntity.ok("upload success Total files are :"+file.length);//return the file name

        }catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());//response with obj
        }
    }
    @GetMapping(value="Readimg/{name}",produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] Readimg(@PathVariable String name){
        logger.info("IN");
        try{
            logger.info("IN");
            String fileWIthPath = UPLOADED_FOLDER+name;
            File file=new File(fileWIthPath);
            if(!file.exists()){
                fileWIthPath=UPLOADED_FOLDER+"no_image.jpg";
            }
            InputStream in = new FileInputStream(fileWIthPath);
            return IOUtils.toByteArray(in);
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }
    @GetMapping(value="ReadImgByid/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] ReadImgByid(@PathVariable Integer id){
        logger.info("IN");
        try{
            logger.info("IN");
            String pic=People_service.ReadImgById(id);
            logger.info("picture name"+pic);
            String fileWIthPath = UPLOADED_FOLDER+pic;
            File file=new File(fileWIthPath);
            InputStream in = new FileInputStream(fileWIthPath);
            logger.info("OUT");
            return IOUtils.toByteArray(in);
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }
    @PostMapping("UploadFileOnlypng")
    public ResponseEntity UploadFileOnlypng(@RequestParam MultipartFile file,@RequestParam Integer Id){
        try{
            logger.info(file.getContentType());
            if(file.getContentType().equalsIgnoreCase("application/pdf") ||
                     file.getContentType().equalsIgnoreCase("application/txt") ||
                    file.getContentType().equalsIgnoreCase("image/jpg")){
                throw new Exception("Invalid field type");
            }
            String folderWithName = UPLOADED_FOLDER+file.getOriginalFilename();
            Path path = Paths.get(folderWithName);//set path with filename
            Files.write(path, file.getBytes());//write the file in the location
            People_service.uploadPicture(file.getOriginalFilename(),Id);
            return ResponseEntity.ok("upload success "+file.getOriginalFilename());//return the file name
        }catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());//response with obj
        }
    }
}