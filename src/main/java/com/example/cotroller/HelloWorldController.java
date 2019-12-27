package com.example.cotroller;

import com.log.LogConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;


@RestController
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class HelloWorldController {

    private static final Logger Logger = LoggerFactory.getLogger(LogConfig.class);

    @RequestMapping(path = {"/hello"},method = RequestMethod.GET)
    public String hello(@RequestParam(value = "userName") String userid, ServletRequest request){
        String userId = request.getParameter("userid");
        System.out.println("hello world userId :" + userId);
        System.out.println("hello world userid :" + userid);
        //System.out.println("测试classPath：" + Thread.currentThread().getContextClassLoader().getResource("/").getPath());
        return "hello World" + userId;
    }



}

