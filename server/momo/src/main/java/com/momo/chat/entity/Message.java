package com.momo.chat.entity;

import com.momo.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
@Getter
@Entity
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue
    private Long id;

    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chatroomId")
    private Chatroom chatroom;

    private LocalDateTime sentTime;

    @Builder
    public Message(String message, Member member, Chatroom chatroom, LocalDateTime sentTime) {
        this.message = message;
        this.member = member;
        this.chatroom = chatroom;
        this.sentTime = sentTime;
    }

}

