package com.example.users;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {
    public static Boolean patternMatches(String value, String fmt) {
        Pattern pattern = Pattern.compile(fmt);
        Matcher mather = pattern.matcher(value);
        return mather.matches();
    }
    public static Boolean validaMail(String mail) {
        return patternMatches(mail, "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    }

    public static Boolean validaPassword(String password) {
        return patternMatches(password, "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{4,8}$");
    }
}
