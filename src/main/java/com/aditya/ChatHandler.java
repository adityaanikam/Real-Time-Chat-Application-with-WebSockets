package com.aditya;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;

@Component
public class ChatHandler extends TextWebSocketHandler {
    private final Set<WebSocketSession> sessions = new CopyOnWriteArraySet<>();
    private final ObjectMapper objectMapper = new ObjectMapper();
    
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        sessions.add(session);
        System.out.println("Connection established: " + session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        try {
            ChatMessage chatMessage = objectMapper.readValue(message.getPayload(), ChatMessage.class);
            
            if ("getHistory".equals(chatMessage.getType())) {
                sendChatHistory(session);
            } else if ("chat".equals(chatMessage.getType())) {
                handleChatMessage(chatMessage);
            }
        } catch (Exception e) {
            System.err.println("Error processing message: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void sendChatHistory(WebSocketSession session) throws Exception {
        List<Message> messages = messageRepository.findAllMessagesOrderByTimestamp();
        
        List<ChatMessage> chatMessages = messages.stream()
                .map(msg -> new ChatMessage(
                    "chat",
                    msg.getText(),
                    msg.getTimestamp().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                    msg.getClientId()
                ))
                .collect(Collectors.toList());
        
        ChatHistoryResponse response = new ChatHistoryResponse("history", chatMessages);
        String jsonResponse = objectMapper.writeValueAsString(response);
        session.sendMessage(new TextMessage(jsonResponse));
    }

    private void handleChatMessage(ChatMessage chatMessage) throws Exception {
        // Save message to database
        Message dbMessage = new Message(
            chatMessage.getText(),
            chatMessage.getClientId(),
            LocalDateTime.parse(chatMessage.getTimestamp(), DateTimeFormatter.ISO_DATE_TIME),
            "chat"
        );
        messageRepository.save(dbMessage);
        
        // Broadcast to all connected sessions
        String jsonMessage = objectMapper.writeValueAsString(chatMessage);
        TextMessage textMessage = new TextMessage(jsonMessage);
        
        for (WebSocketSession s : sessions) {
            if (s.isOpen()) {
                try {
                    s.sendMessage(textMessage);
                } catch (Exception e) {
                    System.err.println("Error sending message to session: " + e.getMessage());
                }
            }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        sessions.remove(session);
        System.out.println("Connection closed: " + session.getId());
    }
    
    // Inner class for chat history response
    public static class ChatHistoryResponse {
        private String type;
        private List<ChatMessage> messages;
        
        public ChatHistoryResponse() {}
        
        public ChatHistoryResponse(String type, List<ChatMessage> messages) {
            this.type = type;
            this.messages = messages;
        }
        
        public String getType() { return type; }
        public void setType(String type) { this.type = type; }
        public List<ChatMessage> getMessages() { return messages; }
        public void setMessages(List<ChatMessage> messages) { this.messages = messages; }
    }
}
