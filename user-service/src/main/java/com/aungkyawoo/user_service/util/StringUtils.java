package com.aungkyawoo.user_service.util;

/**
 * String Utils
 * extends org.springframework.util.StringUtils
 * Author : Aung Kyaw Oo
 */
public class StringUtils extends org.springframework.util.StringUtils {

    /**
     * Generate UUID
     * @return String
     */
    public static String getUUID() {
        return java.util.UUID.randomUUID().toString();
    }
}
