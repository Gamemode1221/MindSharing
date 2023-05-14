//package com.spring.openai;
//..
//import com.theokanning.openai.completion.chat.ChatCompletionRequest;
//import com.theokanning.openai.completion.chat.ChatMessage;
//import com.theokanning.openai.completion.chat.ChatMessageRole;
//import com.theokanning.openai.service.OpenAiService;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//class OpenAiApiTest {
//    public static void main(String... args) {
//
//        OpenAiService service = new OpenAiService("API_KEY");
//
//        System.out.println("Streaming chat completion...");
//
//        final List<ChatMessage> messages = new ArrayList<>();
//        final ChatMessage systemMessage = new ChatMessage(ChatMessageRole.SYSTEM.value(), "Hi, long time no see!");
//
//        messages.add(systemMessage);
//
//        ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest
//                .builder()
//                .model("gpt-3.5-turbo")
//                .messages(messages)
//                .n(1)
//                .maxTokens(50)
//                .logitBias(new HashMap<>())
//                .build();
//
//        service.streamChatCompletion(chatCompletionRequest)
//                .doOnError(Throwable::printStackTrace)
//                .blockingForEach(System.out::println);
//
//        service.shutdownExecutor();
//    }
//}