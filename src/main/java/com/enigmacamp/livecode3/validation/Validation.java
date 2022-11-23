package com.enigmacamp.livecode3.validation;

import java.util.regex.Pattern;

public abstract class Validation {
    public static Boolean validateEmail(String email) {
        String regexPattern = "^(.+)@(\\\\S+)$";

        return Pattern.compile(regexPattern)
                .matcher(email)
                .matches();
    }
}
