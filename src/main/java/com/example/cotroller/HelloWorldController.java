package com.example.cotroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping(path = {"/hello"})
    public String hello(){
        System.out.println("hello world");
        return "hello World";
    }

    public static void main(String[] args) {
        Demo demo = new Demo("张三");
        Demo demo1 = new Demo("李四");
        demo.setPriority(6);
        demo.start();
        demo1.start();
}

}
class Demo extends Thread{

    Demo(String name){
        super(name);
    }

    @Override
    public void run() {
        synchronized (this){
            for (int i = 1 ; i< 50; i++){
                System.out.println("" + this.getName() + "" + i);
//                if (i == 30){
//                    Demo.yield();
//                }
            }
        }
    }


}
