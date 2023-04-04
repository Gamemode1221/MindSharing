//package com.spring.openai;
//
//import com.theokanning.openai.completion.chat.ChatCompletionRequest;
//import com.theokanning.openai.completion.chat.ChatMessage;
//import com.theokanning.openai.completion.chat.ChatMessageRole;
//import com.theokanning.openai.service.OpenAiService;
//import com.theokanning.openai.completion.CompletionRequest;
//import com.theokanning.openai.image.CreateImageRequest;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//class OpenAiApiTest {
//    public static void main(String... args) {
//        OpenAiService service = new OpenAiService("API_KEY");
//
//        String q1 = "Somebody once told me the world is gonna roll me";
//        String q2 = "A cow breakdancing with a turtle";
//        String q3 = "You are a dog and will speak as such.";
//
//        System.out.println("\nCreating completion...");
//        CompletionRequest completionRequest = CompletionRequest.builder()
//                .model("ada")
//                .prompt(q1)
//                .echo(true)
//                .user("testing")
//                .n(3)
//                .build();
//        service.createCompletion(completionRequest).getChoices().forEach(System.out::println);
//
//        System.out.println("\nCreating Image...");
//        CreateImageRequest request = CreateImageRequest.builder()
//                .prompt(q2)
//                .build();
//
//        System.out.println("\nImage is located at:");
//        System.out.println(service.createImage(request).getData().get(0).getUrl());
//
//        System.out.println("Streaming chat completion...");
//        final List<ChatMessage> messages = new ArrayList<>();
//        final ChatMessage systemMessage = new ChatMessage(ChatMessageRole.SYSTEM.value(), q3);
//        messages.add(systemMessage);
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