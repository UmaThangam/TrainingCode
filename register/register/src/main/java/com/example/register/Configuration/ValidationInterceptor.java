//package com.example.register.Configuration;
//
//import com.example.register.Controller.People_controller;
//import com.example.register.Service.People_service;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//@Component
//public class ValidationInterceptor implements HandlerInterceptor {
//    private static final Logger logger = LoggerFactory.getLogger(ValidationInterceptor.class);
//    @Autowired
//    People_service people_service;
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
//        String current_url=request.getRequestURI().toString();
//        logger.info(current_url);
//        if(current_url.contains("people_url/Readimg")
//                || current_url.contains("register_withtoken")
//                || current_url.contains("logincheck")){
//           return true;
//        }
//        String token = request.getHeader("token");
//        String id2 = request.getHeader("id");
//        try {
//            people_service.decode(token);
//            people_service.CheckTokenForUserId(id2, token);//if any error in service method it throw.
//            System.out.println("Request is accepted.Go to the controller.");
//            return true;
//        } catch (Exception e) {
//            //System.out.println("Exception " + e.getMessage());
//            throw new RuntimeException(e.getMessage());
//        }
//    }
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
//    }
//}
