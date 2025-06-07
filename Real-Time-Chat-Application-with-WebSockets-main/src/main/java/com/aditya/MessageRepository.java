package com.aditya;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {
    
    @Query("SELECT m FROM Message m ORDER BY m.timestamp ASC")
    List<Message> findAllMessagesOrderByTimestamp();
    
    @Query("SELECT m FROM Message m WHERE m.clientId = ?1 ORDER BY m.timestamp ASC")
    List<Message> findByClientIdOrderByTimestamp(String clientId);
} 