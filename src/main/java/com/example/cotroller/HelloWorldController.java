package com.example.cotroller;

import com.log.LogConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class HelloWorldController {

    private static final Logger Logger = LoggerFactory.getLogger(LogConfig.class);
    @RequestMapping(path = {"/hello"})
    public String hello(){
        System.out.println("hello world");
        Logger.debug("===========测试debug级别");
        Logger.info("===========测试info级别");
        Logger.warn("===========测试warn级别");
        Logger.error("===========测试error级别");
        return "hello World";
    }



}

