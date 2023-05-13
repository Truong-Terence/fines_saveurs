package com.example.fines_saveurs.util;

import java.lang.reflect.InvocationTargetException;

public class DataHandler {

    public static <T> T handleEmptyParam(String param, Class<T> valueType) {
        T returnedValue = (T) "non renseigné";
        try {
            if (Number.class.isAssignableFrom(valueType) && (!valueType.equals(String.class) && param == null || param.equals(""))) {
                param = "0";
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
