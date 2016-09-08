package com.encuestas.util;

/**
 * Created by JaxKodex on 03/04/2016.
 */
public class StringUtils {

    public static String emptyWhenNullString (String s) {
        if (s == null) {
            return "";
        }
        return s;
    }
}
