package com.aditya;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(columnDefinition = "TEXT")
    private String text;
    
    @Column(name = "client_id")
    private String clientId;
    
    @Column(name = "timestamp")
    private LocalDateTime timestamp;
    
    @Column(name = "message_type")
    private String messageType;
    
    // Default constructor
    public Message() {}
    
    // Constructor with parameters
    public Message(String text, String clientId, LocalDateTime timestamp, String messageType) {
        this.text = text;
        this.clientId = clientId;
        this.timestamp = timestamp;
        this.messageType = messageType;
    }
    
    // Getters and setters
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public String getClientId() {
        return clientId;
    }
    
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getMessageType() {
        return messageType;
    }
    
    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }
} 