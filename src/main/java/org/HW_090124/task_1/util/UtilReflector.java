package org.HW_090124.task_1.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class UtilReflector {
    public static Field[] getAllFields(Object object) {
        return object.getClass().getDeclaredFields();
    }
    public static Method[] getAllMethods(Object object){
        return object.getClass().getDeclaredMethods();
    }

    public static void printObjectInfo(Object object) {
        int modifier = object.getClass().getModifiers();
        System.out.printf("""
                        Class name: %s,\s
                         simple name: %s,\s
                         canonical name: %s,\s
                         located in: %s.\s
                         Modifier is abstract: %s,\s
                         class is final: %s,\s
                         class is public: %s,\s
                         class is static: %s\s
                        """,
                object.getClass().getName(),
                object.getClass().getSimpleName(),
                object.getClass().getCanonicalName(),
                object.getClass().getPackageName(),
                Modifier.isAbstract(modifier),
                Modifier.isFinal(modifier),
                Modifier.isPublic(modifier),
                Modifier.isStatic(modifier)
        );
    }

    public static void executeOrSet(Object object, String name) {
        try {
            Method method = object.getClass().getDeclaredMethod(name);
            executeMethod(object, method);
        } catch (NoSuchMethodException e) {
            try {
                Field field = object.getClass().getDeclaredField(name);
                setField(object, field);
            } catch (NoSuchFieldException | IllegalAccessException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private static void setField(Object object, Field field) throws IllegalAccessException {
        System.out.println("Введите новое значение для поля " + field.getName() + ":");
        Scanner scanner = new Scanner(System.in);
        String newValue = scanner.nextLine();

        field.setAccessible(true);
        if (field.getType() == int.class) {
            field.setInt(object, Integer.parseInt(newValue));
        } else if (field.getType() == boolean.class) {
            field.setBoolean(object, Boolean.parseBoolean(newValue));
        } else {
            field.set(object, newValue);
        }

        System.out.println("Новое значение установлено.");
    }

    //TODO: Implement the case where there is a return value.
    private static void executeMethod(Object object, Method method) {
        try {
            method.setAccessible(true);
            method.invoke(object);
        } catch (IllegalAccessException | InvocationTargetException e) {
            System.out.println("Ошибка при вызове метода: " + e.getMessage());
        }
    }
}
