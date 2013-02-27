package com.wolkenapps.vernum.utils;

public class ClassUtils {

    private ClassUtils() {
    }

    public static Class silentLoad(String type) {
        try {
            return Class.forName(type);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
