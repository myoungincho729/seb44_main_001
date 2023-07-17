package com.momo.chat.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class Chatroom {
    @Id
    @GeneratedValue
    private Long chatroomId;
    private String name;
    private String lastMessage;
    private LocalDateTime lastMessageSentTime;

    @Enumerated(EnumType.STRING)
    private RoomType roomType;

    @Getter
    public enum RoomType {
        PERSONAL, GROUP
    }

    @Builder
    public Chatroom(String name, String lastMessage, LocalDateTime lastMessageSentTime, RoomType roomType) {
        this.name = name;
        this.lastMessage = lastMessage;
        this.lastMessageSentTime = lastMessageSentTime;
        this.roomType = roomType;
    }

    public void addMessage(Message message) {
        this.lastMessage = message.getMessage();
        this.lastMessageSentTime = message.getSentTime();
    }
}
