package com.spring.controller;

import com.spring.Service.ChatGptService;
import com.spring.entity.dto.ChatGptResponseDto;
import com.spring.entity.dto.QuestionRequestDto;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat-gpt")
public class openAIController {

    private final ChatGptService chatGptService;
    public openAIController(ChatGptService chatGptService) {
        this.chatGptService = chatGptService;
    }
    @PostMapping("/question")
    public ChatGptResponseDto sendQuestion(@RequestBody QuestionRequestDto requestDto) {
        return chatGptService.askQuestion(requestDto);
    }

}