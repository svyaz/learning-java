/*
 * Задача
 * • Создать два класса
 * • Самим придумать какие поля и методы у них есть
 * • Прочитать с консоли имя класса (надо чтобы ввели одно из имен классов)
 * • Загрузить класс с указанным именем, используя Class.forName()
 * • Создать экземпляры загруженных классов
 * • Попробовать задать значения их private полям, повызывать методы классов
 */

package com.github.svyaz;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

import com.github.svyaz.javalearning.reflection.*;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String className = "default";
            String instanceName = "nameless";

            System.out.println("Enter animal type:");
            if (scanner.hasNextLine()) {
                className = scanner.nextLine();
            }
            System.out.println("Enter its name:");
            if (scanner.hasNextLine()) {
                instanceName = scanner.nextLine();
            }

            Class<?> myClass = Class.forName(className);
            Constructor<?> myConstructor = myClass.getConstructor(String.class);
            Animal myObject = (Animal) myConstructor.newInstance(instanceName);
            System.out.println("Object created: " + myObject.toString());

            Field nameField = myClass.getDeclaredField("name");
            nameField.setAccessible(true);
            String value = (String) nameField.get(myObject);
            nameField.set(myObject, value + "_modified!");
            System.out.println("Object modified: " + myObject.toString());

            System.out.println("Methods:");
            Method[] myMethods = myClass.getDeclaredMethods();
            boolean hasPrivate = false;
            for (Method method : myMethods) {
                System.out.println("\t" + method.toString());
                int modifiers = method.getModifiers();
                if (Modifier.isPrivate(modifiers)) {
                    hasPrivate = true;
                    System.out.println("\t\tIt's private method. Try to invoke ...");
                    method.setAccessible(true);
                    System.out.println(method.invoke(myObject));
                }
            }

            if (!hasPrivate) {
                System.out.println("\tThere are no private methods. Just call 1-st method ...");
                if (myMethods.length > 0) {
                    System.out.println(myMethods[0].invoke(myObject));
                } else {
                    System.out.println("\tIt has no methods al all.");
                }
            }
        } catch (Exception exception) {
            System.out.println("Something went wrong.");
            exception.printStackTrace();
        }
    }
}
