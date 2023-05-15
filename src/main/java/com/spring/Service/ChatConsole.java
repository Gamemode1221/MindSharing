package com.spring.Service;


import com.spring.config.ChatGptConfig;
import com.spring.entity.dto.ChatGptRequestDto;
import com.spring.entity.dto.ChatGptResponseDto;
import com.spring.entity.dto.Choice;
import org.springframework.http.HttpEntity;

import java.util.List;
import java.util.Scanner;

public class ChatConsole {

    private final ChatGptService chatGptService;

    public ChatConsole(ChatGptService chatGptService) {
        this.chatGptService = chatGptService;
    }

    public void start() {
        System.out.println("Chat with GPT-3: (Type 'exit' to quit)");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("You: ");
            String input = scanner.nextLine().trim();
            if (input.equals("exit")) {
                break;
            }
            ChatGptRequestDto requestDto = ChatGptRequestDto.builder()
                    .model(ChatGptConfig.MODEL)
                    .prompt(input)
                    .maxTokens(ChatGptConfig.MAX_TOKEN)
                    .temperature(ChatGptConfig.TEMPERATURE)
                    .topP(ChatGptConfig.TOP_P)
                    .build();
            HttpEntity<ChatGptRequestDto> requestEntity = chatGptService.buildHttpEntity(requestDto);
            ChatGptResponseDto responseDto = chatGptService.getResponse(requestEntity);
            List<Choice> choices = responseDto.getChoices();
            if (!choices.isEmpty()) {
                Choice choice = choices.get(0);
                String text = choice.getText();
                System.out.println("Bot: " + text);
            }
        }
        scanner.close();
    }
}
