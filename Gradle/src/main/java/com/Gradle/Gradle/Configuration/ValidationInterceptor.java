package com.Gradle.Gradle.Configuration;


import com.Gradle.Gradle.Service.BloggingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ValidationInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(ValidationInterceptor.class);
    @Autowired
    BloggingService bloggingService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String current_url=request.getRequestURI().toString();
        if (current_url.contains("Register")
                || current_url.contains("Login")
                || current_url.contains("getCountry")
                ||current_url.contains("SearchUser")
                || current_url.contains("CountData")

        ) {
            logger.info("dfg");
            return true;
        }
//        String token = request.getHeader("token");
//        String id2 = request.getHeader("id");
//        try {
//            logger.info(token);
//            logger.info(id2);
//            bloggingService.CheckTokenForUserId(id2,token);
//            Integer id3=Integer.parseInt(id2);
//            String role  = bloggingService.GetRole(id3);
//            String url[] = current_url.split("/");
//            logger.info(url[2]);
//            Boolean status =bloggingService.CheckRole(url[2],role);
//            if(status==false){
//                throw new Exception("Can't Accesss The Api");
//            }
//            return true;
//        } catch (Exception e) {
//            logger.info(e.getMessage());
//            throw new RuntimeException(e.getMessage());
//        }
       return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    }
}
