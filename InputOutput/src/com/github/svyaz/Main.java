package com.github.svyaz;

/*
Задача 1
• Побайтово скопировать файл
• Использовать буферизованные байтовые потоки, использовать цикл при чтении

Задача 2
• Создать файл и записать в него 100 строк вида «Строка 1», «Строка 2» и т.д. до «Строка 100»
• Записать в файл еще несколько произвольных строк при помощи методов printf(), print(), println()
• Использовать PrintWriter
 */

import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Task 1
        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream("InputOutput/task1Input.txt"));
             BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("InputOutput/task1Output.txt"))) {
            int currentByte;
            while ((currentByte = input.read()) != -1) {
                output.write(currentByte);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
