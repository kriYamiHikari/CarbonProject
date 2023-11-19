package com.example.carbonproject.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ObjectUtil {
    public static List<String> getObjectFieldNames(Object obj) {
        List<String> fieldNames = new ArrayList<>();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            fieldNames.add(field.getName());
        }
        return fieldNames;
    }
}
