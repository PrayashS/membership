/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.membership.util;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;
import java.text.ParseException;
//


public class ValidationUtils {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[A-Za-z]{2,}$");

    public static boolean isValidName(String name) {
        return name.matches("[a-zA-Z\\s]+");
    }

    public static boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean isValidBirthdate(String birthdate) {
        try {
            DATE_FORMAT.parse(birthdate);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}

