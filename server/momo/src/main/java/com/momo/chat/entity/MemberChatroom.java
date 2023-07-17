package com.momo.chat.entity;

import com.momo.member.entity.Member;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class MemberChatroom {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberId")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chatroomId")
    private Chatroom chatroom;

    private Long unreadCount;

    @Builder
    public MemberChatroom(Member member, Chatroom chatroom) {
        this.member = member;
        this.chatroom = chatroom;
        this.unreadCount = 0L;
    }


}
