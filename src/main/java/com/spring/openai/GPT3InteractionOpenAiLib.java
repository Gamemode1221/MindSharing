//package com.spring.openai;
//
//import ai.openai.*;
//import java.io.IOException;
//import java.util.Scanner;
//
//public class GPT3InteractionOpenAiLib {
//    private static final String API_KEY = "your_api_key_here";
//
//    public static void main(String[] args) throws IOException {
//        OpenAIClient client = OpenAIClient.newBuilder().withApiKey(API_KEY).build();
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Enter your message: ");
//        String message = scanner.nextLine();
//
//        String prompt = "User: " + message + "\nAI:";
//
//        CompletionRequest completionRequest = CompletionRequest.builder()
//                .engine("gpt-3.5-turbo")
//                .prompt(prompt)
//                .maxTokens(150)
//                .temperature(0.5)
//                .build();
//
//        try {
//            Completion completion = client.createCompletion(completionRequest);
//            String aiResponse = completion.getChoices().get(0).getText().trim();
//            System.out.println("AI: " + aiResponse);
//        } catch (ApiException e) {
//            System.err.println("Error: " + e.getCode() + " " + e.getMessage());
//        }
//
//        scanner.close();
//    }
//}
