//package com.learnbyheart.demo1.websocket;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.learnbyheart.demo1.config.GetHttpSessionConfigurator;
//import com.learnbyheart.demo1.pojo.Message;
//import com.learnbyheart.demo1.util.MessageUtils;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.http.HttpSession;
//import javax.websocket.*;
//import javax.websocket.server.ServerEndpoint;
//import java.util.Map;
//import java.util.Set;
//import java.util.concurrent.ConcurrentHashMap;
//
////@Component
////@ServerEndpoint(value = "/chat",configurator = GetHttpSessionConfigurator.class)
//public class ChatPoint {
//    private static Map<String,ChatPoint> onlineUsers = new ConcurrentHashMap<>();
//    private Session session;
//    private HttpSession httpSession;
//    //建立连接
//    @OnOpen
//    public void onOpen(Session session, EndpointConfig config) {
//        this.session = session;
//        this.httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
//
//        String name = (String) httpSession.getAttribute("user");
//        onlineUsers.put(name, this);
//        String msg = MessageUtils.getMsg(true, null, getName());
//        broadcastAllUSers(msg);
//
//    }
//    private void broadcastAllUSers(String msg){
//        Set<String> names = getName();
//        for(String name:names){
//            ChatPoint chatPoint = onlineUsers.get(name);
//            try {
//                chatPoint.session.getBasicRemote().sendText(msg);
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//
//        }
//
//    }
//
//    private Set<String> getName(){
//        return onlineUsers.keySet();
//    }
//
//    //收到消息
//    @OnMessage
//    public void onMessage(String msg,Session session){
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            Message message = mapper.readValue(msg, Message.class);
//            String toName = message.getToName();
//            String data = message.getMessage();
//            String name = (String) httpSession.getAttribute("user");
//            String result = MessageUtils.getMsg(false, name, data);
//            //  发送
//            onlineUsers.get(toName).session.getBasicRemote().sendText(result);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//    }
//    //关闭
//    @OnClose
//    public void onClose(Session session){
//        String name = (String)httpSession.getAttribute("user");
//
//        onlineUsers.remove(name);
//        MessageUtils.getMsg(true,null,getName());
//    }
//}
