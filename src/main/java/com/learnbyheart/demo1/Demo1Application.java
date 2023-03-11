package com.learnbyheart.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@SpringBootApplication
public class Demo1Application {
    /**
     * 基于websocket的简易聊天
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
    /**
     *
     * websocket的实现
     * 先注入 ServerEndpointExporter这个对象是开启websocket
     * 前端编写ajax 调用后端接口 @ServerEndpoint(value = "/p2p")
     * 然后里面就是具体的实现
     * @OnOpen
     * @OnClose
     * @OnMessage
     * 里面的Session就是从前端传递的session
     *
     */

}
