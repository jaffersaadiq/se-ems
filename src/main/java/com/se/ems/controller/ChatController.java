package com.se.ems.controller;

import com.se.ems.dto.MessageDto;
import com.se.ems.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/se-ems/assistant")
@CrossOrigin("*")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @PostMapping
    public MessageDto sendMessage(@RequestBody MessageDto message) {
        return chatService.chat(message);
    }


}
