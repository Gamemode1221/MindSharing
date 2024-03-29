package com.spring.controller;

import com.spring.Service.ChatService;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/api/v1/chat-gpt")
public class gptapiController {
    private final ChatService chatService;
    private final ChatgptService chatgptService;

    @PostMapping("")
    public String test(@RequestBody String question){
        return chatService.getChatResponse(question);
    }
}