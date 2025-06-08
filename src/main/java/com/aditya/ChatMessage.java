package com.aditya;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChatMessage {
    private String type;
    private String text;
    private String timestamp;
    private String clientId;
    
    // Default constructor
    public ChatMessage() {}
    
    // Constructor
    public ChatMessage(String type, String text, String timestamp, String clientId) {
        this.type = type;
        this.text = text;
        this.timestamp = timestamp;
        this.clientId = clientId;
    }
    
    // Getters and setters
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getText() {
        return text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public String getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    
    @JsonProperty("clientId")
    public String getClientId() {
        return clientId;
    }
    
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
} 