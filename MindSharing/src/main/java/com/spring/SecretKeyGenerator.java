package com.spring;

import java.security.SecureRandom;
import java.util.Base64;

public class SecretKeyGenerator {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        byte[] secretKeyBytes = new byte[32];
        random.nextBytes(secretKeyBytes);
        String secretKey = Base64.getEncoder().encodeToString(secretKeyBytes);
        System.out.println("Secret Key: " + secretKey);
    }
}
