package com.enigmacamp.livecode3.validation;

import org.apache.commons.validator.routines.EmailValidator;

import java.util.regex.Pattern;

public abstract class Validation {
    private static final EmailValidator emailValidator = EmailValidator.getInstance();
    public static Boolean validateEmail(String email) {
        return emailValidator.isValid(email);
    }

//    It allows numeric values from 0 to 9.
//    Both uppercase and lowercase letters from a to z are allowed.
//    Allowed are underscore “_”, hyphen “-“, and dot “.”
//    Dot isn't allowed at the start and end of the local part.
//    Consecutive dots aren't allowed.
//    For the local part, a maximum of 64 characters are allowed.
}
