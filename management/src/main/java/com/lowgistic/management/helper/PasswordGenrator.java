package com.lowgistic.management.helper;

import org.apache.commons.lang.RandomStringUtils;

public class PasswordGenrator {

    private PasswordGenrator() {
    }

    public static String generatePassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_=+[{]}|;:,<.>?";
        return RandomStringUtils.random( 8, characters );
    }
}
