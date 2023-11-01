package com.codegym.thai_foody_casestudy_module03.Model.Utils;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class Converter {
    public static String removeAccent(String text) {
        text = text.toUpperCase().trim();
        String temp = Normalizer.normalize(text,Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCOMBINING_DIACRITICAL_MARKS}+");
        temp = pattern.matcher(temp).replaceAll("");
        temp.replaceAll("Đ","D");
        System.out.println(temp);
        return temp;
    }
}
