package com.enigmacamp.livecode3.utils;

public abstract class PasswordEncrypt {
    private static final TrippleDes td;

    static {
        try {
            td = new TrippleDes();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String startEncrypt(String target) {
        return td.encrypt(target);
    }

    public static String startDecrypt(String encrypted) {
        return td.decrypt(encrypted);
    }
}
