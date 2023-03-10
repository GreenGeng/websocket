package com.learnbyheart.demo1.websocket;

import com.learnbyheart.demo1.config.GetHttpSessionConfigurator;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@Component
@ServerEndpoint(value = "/p2p")
public class P2PWebsocket {

    private static Session[] sessions = new Session[2];

    @OnOpen
    public void onOpen(Session session){
        if(sessions[0] == null && sessions[1]== null){
            sessions[0] = session;
            System.out.println("a进入");
        }
        else if(sessions[0] != null && sessions[1]==null){
            sessions[1] = session;
            System.out.println("接入b");
        }
        else{

        }
    }

    @OnClose
    public void onClose(Session session){
        for (int i = 0; i < sessions.length; i++) {
            if(session == sessions[i]){
                sessions[i] = null;
                System.out.println(i+"退出");
            }
        }
    }

    //返回另一个session
    private Session getOtherSession(Session session){
        for (int i = 0; i < sessions.length; i++) {
            if(session == sessions[i]){
                return sessions[(i==0?1:0)];
            }
        }
        return null;
    }

    //发送消息
    @OnMessage
    public void sendMsg(String msg,Session session) throws  Exception{
        Session otherSession = this.getOtherSession(session);
        otherSession.getBasicRemote().sendText(msg);

    }
    // 异常处理
    @OnError
    public void onErr(Session session,Throwable err){
        System.out.println(err);
    }


}
