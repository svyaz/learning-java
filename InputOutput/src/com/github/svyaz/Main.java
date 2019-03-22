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
import java.util.Date;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Task 1
        try (BufferedInputStream input = new BufferedInputStream(new FileInputStream("InputOutput/task1Input.txt"));
             BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream("InputOutput/task1Output.txt"))) {
            int read;
            int off = 0;
            byte[] result = new byte[1_000_000];
            while ((read = input.read(result, off, result.length - off)) != -1) {
                output.write(result, off, read);
                off += read;
            }
        } catch (IOException exception) {
            System.out.println("Task 1 failed.");
            exception.printStackTrace();
        }

        // Task 2
        try (PrintWriter writer = new PrintWriter(new FileOutputStream("InputOutput/Task2Output.txt"))) {
            Stream.iterate(1, n -> n + 1)
                    .limit(100)
                    .map(n -> "Строка " + n)
                    .forEach(writer::println);

            writer.printf("--- From printf: PI = %.10f%n", Math.PI);
            writer.println("--- From println: Hello, file!");
            writer.print("--- From print: " + new Date().toString());
        } catch (FileNotFoundException exception) {
            System.out.println("Task 2 failed.");
            exception.printStackTrace();
        }
    }
}
