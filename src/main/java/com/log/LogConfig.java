package com.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉<br>
 * 〈日志配置文件〉
 *
 * @author baiwc
 * @date 2019-12-10 17:54
 * @since 2019.12.10
 */
@Configuration
public class LogConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogConfig.class);

    @Bean
    public void Test(){
        LOGGER.info("==============日志测试类==========");
   }
}