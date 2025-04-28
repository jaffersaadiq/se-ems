package com.se.ems.services;

import com.se.ems.dto.MessageDto;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    @Autowired
    ChatClient chatClient;


    public MessageDto chat(MessageDto messageDto) {
        String response = chatClient.prompt().user(messageDto.getMessage()).call().content();
        messageDto.setResponse(response);
        return messageDto;
    }

}

