package org.selenium.utils;

import java.util.Locale;

public class StringUtils {

    public boolean doesBothTheTextsMatches(String str, String str1) {
        return str.equals(str1);
    }

    public boolean containsIgnoreCase(String mainStr, String subStr) {
        return mainStr.toLowerCase(Locale.ROOT).contains(subStr.toLowerCase(Locale.ROOT));
    }
}
