package com.rabbitMQ;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 〈一句话功能简述〉<br>
 * 〈rabbitMQ配置文件〉
 *
 * @author baiwc
 * @date 2019-12-26 20:00
 * @since 2019.12.26
 */
@Configuration
@Slf4j
public class RabbitConfig {

    /**
     * 队列
     */
    @Bean
    Queue testDirectQueue(){
        return new Queue("TestDirectQueue",true);
    }

    /**
     * 交换机
     */
    @Bean
    DirectExchange testDirectExchange(){
        return new DirectExchange("TestDirectExchange");
    }

    /**
     * 声明绑定关系
     */
    @Bean
    Binding bindingDirect(){
        return BindingBuilder.bind(testDirectQueue()).to(testDirectExchange()).with("TestDirectRouting");
    }



}