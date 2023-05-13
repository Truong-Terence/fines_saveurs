package com.example.fines_saveurs.util;

import java.lang.reflect.InvocationTargetException;

public class DataHandler {

    public static <T> T parseParam(String param, Class<T> valueType) {
        T returnedValue = (T) "";
        try {
            if (Number.class.isAssignableFrom(valueType)) {
                if (param == null || param.equals("")) param = "0";
                returnedValue = (T) valueType
                        .getDeclaredMethod("valueOf", String.class)
                        .invoke(null, param);
            }
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException error) {
            error.printStackTrace();
        }
        return returnedValue;
    }
}