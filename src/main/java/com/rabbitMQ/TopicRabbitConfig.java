package com.rabbitMQ;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 〈一句话功能简述〉<br>
 * 〈订阅模式〉
 *
 * @author baiwc
 * @date 2019-12-27 20:58
 * @since 2019.12.27
 */
@Component
@Slf4j
public class TopicRabbitConfig {

    private static final String MAN =  "topic.main";
    private static final String WOMAN = "topic.woman";

    @Bean
    public Queue firstQueue(){
        log.info("firstQueue init=================>");
        return new Queue(TopicRabbitConfig.MAN);
    }

    @Bean
    public Queue secondQueue(){
        log.info("secondQueue inti=================>");
        return new Queue(TopicRabbitConfig.WOMAN);
    }

    @Bean
    TopicExchange exchange(){
        return new TopicExchange("TopicExchange");
    }

    @Bean
    Binding bindingExchangeMessageMan(){
        return BindingBuilder.bind(firstQueue()).to(exchange()).with(TopicRabbitConfig.MAN);
    }

    @Bean
    Binding bindingExchangeMessageAll(){
        return BindingBuilder.bind(secondQueue()).to(exchange()).with("topic.#");
    }

}