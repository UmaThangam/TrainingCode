package com.Gradle.Gradle.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class ApiAccessProps {
    private static final Logger logger = LoggerFactory.getLogger(ApiAccessProps.class);
    public static boolean checkRole(String role,String api){
        logger.info(api);
        try{
            logger.info("IN");
            //logger.info(api);
            HashMap<String,String> apiList = new HashMap<String,String>();
            apiList.put("GetDataById","USER");
            apiList.put("GetAllData","ADMIN");
            //Blogging_url/GetDataById/1
            String url[] = api.split("/");
            return apiList.get(url[2]).equals(role);
        }catch (Exception e){
            logger.error(e.getMessage());
            return false;
        }
    }
}
