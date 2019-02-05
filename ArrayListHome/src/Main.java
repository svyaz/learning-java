/*
Задача “ArrayListHome”

1. Прочитать в список все строки из файла

2. Есть список из целых чисел. Удалить из него все четные числа. В этой задаче новый список создавать нельзя.

3. Есть список из целых чисел, в нём некоторые числа могут повторяться. Надо создать новый список,
   в котором будут элементы первого списка в таком же порядке, но без повторений.
   Например, был список [1, 5, 2, 1, 3, 5],
   должен получиться новый список [1, 5, 2, 3].
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // --- 1 ---
        try (Scanner scanner = new Scanner(new FileInputStream("ArrayListHome/inputStrings.txt"), String.valueOf(StandardCharsets.UTF_8))) {
            ArrayList<String> list = new ArrayList<>();
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
            if (list.isEmpty()) {
                System.out.println("File is empty.");
            } else {
                for (String string : list) {
                    System.out.println(string);
                }
            }
        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
        System.out.println();

        // --- 2 ---
        ArrayList<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 4, 2, 8, 7, 1, 9, 10, 24, 5, 6));
        System.out.println("List before: " + numbersList.toString());
        int i = 0;
        while (i < numbersList.size()) {
            if (numbersList.get(i) % 2 == 0) {
                numbersList.remove(i);
                continue;
            }
            i++;
        }
        System.out.println("List after:  " + numbersList.toString());
        System.out.println();

        // --- 3 ---
        ArrayList<Integer> inputList = new ArrayList<>(Arrays.asList(1, 128, 5, 2, 1, 3, 5, 128, 129));
        ArrayList<Integer> outputList = new ArrayList<>();
        System.out.println("inputList:  " + inputList.toString());
        for (int element : inputList) {
            if (!outputList.contains(element)) {
                outputList.add(element);
            }
        }
        System.out.println("outputList: " + outputList.toString());
    }

}
