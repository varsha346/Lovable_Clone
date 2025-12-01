package com.lovable.demo.entity;

import com.lovable.demo.enums.MessageRole;

import java.time.Instant;

public class Chat_Message {

    long id;
    Chat_Session chatSession;
    String content;
    String toolCalls;
    MessageRole msgRole;
    Instant tokensUsed;
    Instant createAt;
}
