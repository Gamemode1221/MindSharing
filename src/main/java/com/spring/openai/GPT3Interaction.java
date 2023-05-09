package com.spring.openai;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import okhttp3.*;

import java.io.IOException;
import java.util.Scanner;

public class GPT3Interaction {

    private static final String API_KEY = "API_KEY";
    private static final String API_URL = "https://api.openai.com/v1/completions";
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your message: ");
        String message = scanner.nextLine();

        String prompt = "User: " + message + "\nAI:";
        JsonObject requestBody = new JsonObject();
        requestBody.addProperty("prompt", prompt);
        requestBody.addProperty("max_tokens", 150);
        requestBody.addProperty("temperature", 0.5);

        Request request = new Request.Builder()
                .url(API_URL)

                .addHeader("Authorization", "Bearer " + API_KEY)
                .addHeader("Content-Type", "application/json")
                .post(RequestBody.create(requestBody.toString(), JSON))
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                String responseBody = response.body().string();
                JsonObject jsonResponse = gson.fromJson(responseBody, JsonObject.class);
                String aiResponse = jsonResponse.getAsJsonArray("choices")
                        .get(0)
                        .getAsJsonObject()
                        .get("text")
                        .getAsString()
                        .trim();

                System.out.println("AI: " + aiResponse);
            } else {
                System.err.println("Error: " + response.code() + " " + response.message());
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
