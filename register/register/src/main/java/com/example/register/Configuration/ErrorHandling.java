//package com.example.register.Configuration;
//
//import com.example.register.Response.People_response;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//@ControllerAdvice//will be catch error in the application.
//    public class ErrorHandling {
//        @ExceptionHandler(RuntimeException.class)
//        public ResponseEntity handlingRunTimeExcpetion(RuntimeException e){
//            People_response res = new People_response();
//            res.setMessage(e.getMessage());
//            return ResponseEntity.badRequest().body(res);
//        }
//}
