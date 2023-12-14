package com.example.carbonproject.controller.websocket;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@ServerEndpoint("/websocket/chat/{userEmail}")
public class ChatWebSocket {
    private Session session;
    private String userEmail;
    private static CopyOnWriteArrayList<ChatWebSocket> webSocketSet = new CopyOnWriteArrayList<>();
    private static ConcurrentHashMap<String, Session> sessionMap = new ConcurrentHashMap<String, Session>();

    @OnOpen
    public void onOpen(Session session, @PathParam("userEmail") String userEmail, EndpointConfig config) {
        this.session = session;
        this.userEmail = userEmail;
        webSocketSet.add(this);
        sessionMap.put(userEmail, session);
        session.getAsyncRemote().sendText("欢迎连接服务器！" + userEmail);
        for (ChatWebSocket webSocket : webSocketSet) {
            String string = String.format("%s上线了！%n当前在线列表：%s", userEmail, sessionMap.keySet());
            webSocket.session.getAsyncRemote().sendText(string);
        }
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        sessionMap.remove(userEmail);
        for (ChatWebSocket webSocket : webSocketSet) {
            String string = String.format("%s离线了！%n当前在线列表：%s", userEmail, sessionMap.keySet());
            webSocket.session.getAsyncRemote().sendText(string);
        }
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            LinkedHashMap<String, Object> map = objectMapper.readValue(message, new TypeReference<LinkedHashMap<String, Object>>() {
            });
            session.getAsyncRemote().sendText(map.get("message").toString());
        } catch (JsonMappingException e) {
            session.getAsyncRemote().sendText("fuck you noob!");
        } catch (JsonProcessingException e) {
            session.getAsyncRemote().sendText("fuck you noob aim!");
        }
//        if (message.equals("fuck you!")) {
//            session.getAsyncRemote().sendText("fuck you too!");
//        }
    }
}
