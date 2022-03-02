package com.mustoutdoor.testserverapi.common.utils;

import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

public class StringUtil extends StringUtils {

    public static final String EMPTY_STRING = "";
    public static final String UNDEFINED = "undefined";

    public static boolean isNotEmpty(@Nullable String object) {
        return !isEmpty(object);
    }

    public static boolean isEmpty(@Nullable String str) {
        return (str == null || EMPTY_STRING.equals(str) || UNDEFINED.equals(str.toLowerCase()) || UNDEFINED.equals(str.toUpperCase()));
    }

}
