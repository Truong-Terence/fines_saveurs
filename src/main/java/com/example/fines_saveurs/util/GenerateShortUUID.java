package com.example.fines_saveurs.util;


public class GenerateShortUUID {

    public static String next(int length) {
        return toIDString(length);
    }

    private static String toIDString(int length) {
        char[] buf = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) Math.floor(Math.random() * DIGITS36.length);
            buf[i] = DIGITS36[rand];
        }
        return new String(buf);
    }


    private final static char[] DIGITS36 = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

}
