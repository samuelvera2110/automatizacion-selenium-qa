package com.example.utils;

import java.util.UUID;

public class DataGenerator {
    public static String generateUsername() {
        return "user_" + UUID.randomUUID().toString().substring(0, 8);
    }

    public static String generatePassword() {
        return "Pass_" + UUID.randomUUID().toString().substring(0, 8);
    }
}
