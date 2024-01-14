package org.HW_110124.task_1.event.processor;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.HW_110124.task_1.reflection.helper.ReflectionHelper;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EventProcessor {
    public static List<Object> setToEventProcessSystem(String packageName, Class<? extends Annotation> annotation) {
       List<Object> eventHandlers = new ArrayList<>();

       List<Class<?>> handlerClasses = ReflectionHelper.findAnnotatedClasses(packageName, annotation);

       handlerClasses.forEach(c -> {
                   try {
                       Constructor<?> constructor = c.getConstructor();
                       Object handlerInstance = constructor.newInstance();
                       eventHandlers.add(handlerInstance);

                   } catch (NoSuchMethodException | InvocationTargetException | InstantiationException |
                            IllegalAccessException e) {
                       e.printStackTrace();
                   }
               });
       return eventHandlers;
    }
}