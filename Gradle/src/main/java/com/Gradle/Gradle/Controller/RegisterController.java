package com.Gradle.Gradle.Controller;


import com.Gradle.Gradle.Request.LoginRequest;
import com.Gradle.Gradle.Request.Password_request;
import com.Gradle.Gradle.Request.RegisterRequest;
import com.Gradle.Gradle.Response.BloggingResponse;
import com.Gradle.Gradle.Response.LoginResponse;
import com.Gradle.Gradle.Service.BloggingService;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

@RestController
@RequestMapping("Blogging_url")
public class RegisterController {
    private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
    @Autowired
    BloggingService bloggingService;
    @Autowired
    Environment env;
    String UPLOADED_FOLDER="C:\\Users\\10592\\Uploadfile\\";

    @PostMapping("Register")
    public ResponseEntity Register(@RequestBody RegisterRequest registerRequest){
        BloggingResponse bloggingResponse=new BloggingResponse();
        logger.info("IN");
        try{
            this.bloggingService.Register(registerRequest);
            bloggingResponse.setMessage("Register Successfully");
            return ResponseEntity.ok(bloggingResponse);
        }catch (Exception e){
            logger.info(e.getMessage());
            bloggingResponse.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(bloggingResponse);
        }
    }
    @PostMapping("Login")
     public ResponseEntity Login(@RequestBody LoginRequest loginRequest){
        BloggingResponse bloggingResponse=new BloggingResponse();
        logger.info("IN");
        logger.info(""+loginRequest.getPassword());
        logger.info(""+loginRequest.getEmail());
        try{
            LoginResponse loginResponse=this.bloggingService.Login(loginRequest);
            return ResponseEntity.ok(loginResponse);
        }catch (Exception e){
            logger.error(e.getMessage());
            bloggingResponse.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(bloggingResponse);
        }
    }
    @GetMapping("GetDataById/{id}")
    public ResponseEntity GetDataById(@PathVariable Integer id, @RequestHeader("id") Integer id_header){
        BloggingResponse bloggingResponse=new BloggingResponse();
        logger.info("IN");
        try {
            if(id.equals(id_header)){
                return ResponseEntity.ok(this.bloggingService.GetDataFromTable(id));
            }else
                throw new RuntimeException(" Don't have access to api");
        } catch (Exception e){
            logger.error(e.getMessage());
            throw new RuntimeException(" Don't have access to api");
        }
    }
    @GetMapping("GetAllData")
    public ResponseEntity GetAllData(){
        BloggingResponse bloggingResponse=new BloggingResponse();
        logger.info("IN");
        try {
            return ResponseEntity.ok(this.bloggingService.GetAllData());
        } catch (Exception e){
            logger.error(e.getMessage());
            bloggingResponse.setMessage(e.getMessage());
            throw new RuntimeException(e.getMessage());//response with obj
        }
    }
    @GetMapping("Logout/{id}")
    public ResponseEntity logout(@PathVariable Integer id ){
        BloggingResponse bloggingResponse=new BloggingResponse();
        try{
            bloggingService.userUpdateToken(id,"");
            return ResponseEntity.ok(bloggingResponse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("password")
    public ResponseEntity password(@RequestBody Password_request obj) {
        BloggingResponse bloggingResponse=new BloggingResponse();
        logger.info("controlller");
        try {
            this.bloggingService.update_password(obj);
            bloggingResponse.setMessage("Uploaded Successfully");
            return ResponseEntity.ok(bloggingResponse);
        } catch (Exception e) {
            e.printStackTrace();//the response will print the consle page
            bloggingResponse.setMessage(e.getMessage());
            return ResponseEntity.badRequest().body(bloggingResponse);
        }
    }
    @PostMapping("uploadFile1")
    public ResponseEntity uploadFile(@RequestParam MultipartFile file,@RequestParam Integer id){
        BloggingResponse bloggingResponse=new BloggingResponse();
        try{
            String fileName = file.getOriginalFilename();
            String folderWithName = UPLOADED_FOLDER+fileName;
            Path path = Paths.get(folderWithName);
            Files.write(path, file.getBytes());
            bloggingService.uploadPicture(fileName,id);
            bloggingResponse.setMessage("Uploaded Successfully");
            return ResponseEntity.ok(bloggingResponse);
        }catch (Exception e){
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @GetMapping(value="ReadImgByid1/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] ReadImgByid(@PathVariable Integer id){
        BloggingResponse bloggingResponse=new BloggingResponse();
        logger.info("IN");
        try{
            logger.info("IN");
            String pic=bloggingService.ReadImgById(id);
            logger.info("picture name"+pic);
            String fileWIthPath = UPLOADED_FOLDER+pic;
            File file=new File(fileWIthPath);
            if(!file.exists()){
                fileWIthPath=UPLOADED_FOLDER+"no_image.jpg";
            }
            InputStream in = new FileInputStream(fileWIthPath);
            logger.info("OUT");
            return IOUtils.toByteArray(in);
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }
}
