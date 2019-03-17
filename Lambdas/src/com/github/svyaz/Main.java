package com.github.svyaz;

import com.github.svyaz.javalearning.lambdas.Person;

import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        /*
         * List of Persons
         */
        List<Person> persons = Arrays.asList(
                new Person("Аркадий", 20),
                new Person("Борис", 15),
                new Person("Анастасия", 17),
                new Person("Василий", 46),
                new Person("Василий", 12),
                new Person("Борис", 24)
        );

        /*
         * А) получить список уникальных имен
         * Б) вывести список уникальных имен в формате: Имена: Иван, Сергей, Петр.
         */
        String names = persons
                .stream()
                .map(Person::getName)
                .distinct()
                .collect(Collectors.joining(", ", "", "."));
        System.out.println("Имена: " + names);
        System.out.println();

        /*
         * В) получить список людей младше 18, посчитать для них средний возраст
         */
        double average = persons
                .stream()
                .filter(person -> person.getAge() < 18)
                .mapToInt(Person::getAge)
                .average()
                .orElse(0);
        System.out.printf("Средний возраст тех кому меньше 18 лет: %.2f%n", average);
        System.out.println();

        /*
         * Г) при помощи группировки получить Map, в котором ключи – имена, а значения – средний возраст
         */
        Map<String, Double> namesMap = persons
                .stream()
                .collect(Collectors.groupingBy(Person::getName,
                        Collectors.averagingInt(Person::getAge)));
        System.out.println("Мэп с группировкой по имени и средним возрастом:");
        System.out.println(namesMap.toString());
        System.out.println();

        /*
         * Д) получить людей, возраст которых от 20 до 45, вывести в консоль их имена в порядке убывания возраста
         */
        String sortedNamesString = persons.stream()
                .filter(a -> a.getAge() >= 20 && a.getAge() <= 45)
                .map(Person::getName)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.joining(", "));
        System.out.println("Список имен тех кому от 20 до 45 в обратном порядке:");
        System.out.println(sortedNamesString);
        System.out.println();

        /*
         * Попробовать реализовать бесконечный поток чисел Фиббоначчи
         */
        List<Integer> fibonacciRow = Stream
                .iterate(new int[]{0, 1}, n -> new int[]{n[1], n[0] + n[1]})
                .map(n -> n[0])
                .limit(20)
                .collect(Collectors.toList());
        System.out.println("Fibonacci row: " + fibonacciRow);
        System.out.println();

        /*
         * Создать бесконечный поток корней чисел. С консоли прочитать число –
         * сколько элементов нужно вычислить, затем – распечатать эти элементы.
         */
        try (Scanner scanner = new Scanner(new InputStreamReader(System.in))) {
            System.out.println("Enter number to get square root till:");
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("It must be integer value. Try again.");
            }
            int n = scanner.nextInt();

            List<Double> resultList = Stream
                    .iterate(1, i -> i + 1)
                    .map(Math::sqrt)
                    .limit(n)
                    .collect(Collectors.toList());
            System.out.println("result = " + resultList);
        } catch (Exception exception) {
            System.out.println("Something went wrong: " + exception.getMessage());
        }
    }
}
