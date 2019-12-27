package com.example.cotroller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 〈一句话功能简述〉<br>
 * 〈生产者消息推送〉
 *  RestController注解相当于是Controller注解和@ResponseBody注解的结合
 *  返回json数据不需要添加@ResponseBody注解
 *  但是不能返回html,jsp页面
 *
 * @author baiwc
 * @date 2019-12-26 21:10
 * @since 2019.12.26
 */
@RestController
public class SendMessageController {


    private RabbitTemplate rabbitTemplate;

    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/sendMessage")
    public String sendMessage(){
        String messageId = String.valueOf(UUID.randomUUID());
        String message = "Test message,hello";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> messageMap = new HashMap<>(16);
        messageMap.put("messageId",messageId);
        messageMap.put("message",message);
        messageMap.put("createTime",createTime);
        rabbitTemplate.convertAndSend("TestDirectExchange","TestDirectRouting",messageMap);
        return "OK";
    }

    @GetMapping("/sendMessageMan")
    public String sendMessageMan(){
        String messageId = String.valueOf(UUID.randomUUID());
        String message = "Test message,man";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> messageMap = new HashMap<>(16);
        messageMap.put("messageId",messageId);
        messageMap.put("message",message);
        messageMap.put("createTime",createTime);
        rabbitTemplate.convertAndSend("TopicExchange","topic.main",messageMap);
        return "OK";
    }

    @GetMapping("/sendMessageWoman")
    public String sendMessageWoman(){
        String messageId = String.valueOf(UUID.randomUUID());
        String message = "Test message,woman";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String,Object> messageMap = new HashMap<>(16);
        messageMap.put("messageId",messageId);
        messageMap.put("message",message);
        messageMap.put("createTime",createTime);
        rabbitTemplate.convertAndSend("TopicExchange","topic.woman",messageMap);
        return "OK";
    }




}