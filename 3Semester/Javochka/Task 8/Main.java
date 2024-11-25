package com.example.zadanie8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args) {

// задание 1
        List<String> list = new ArrayList<>(Arrays.asList("Зима", "Весна", "Весна", "Осень", "Лето", "Лето", "Зима", "Осень", "Весна","Зимап", "Лето"));
        System.out.println(list.stream()
                .collect(groupingBy(Function.identity(), counting()))
                .entrySet().stream()
                .collect(groupingBy(Map.Entry::getValue, mapping(Map.Entry::getKey, toCollection(TreeSet::new))))
                .entrySet().stream()
                .max(Map.Entry.comparingByKey())
                .map(longTreeSetEntry -> longTreeSetEntry.getValue().stream().sorted(Comparator.reverseOrder()).collect(joining(", ")))
                .orElse(""));

// задание 2
        List<Contact> contacts = new ArrayList<>(Arrays.asList(
                new Contact("Елисей", "Смирнов", 24, "5828556435"),
                new Contact("Валерия", "Ромашков", 43, "6937598858"),
                new Contact("Татьяна", "Баранкина", 18, "33465898836"),
                new Contact("Ксения", "Волкова", 50, "845778257"),
                new Contact("Роман", "Есенин", 26, "4958869823"),
                new Contact("Dжек", "Дэвидсон", 30, "1498591902")
        ));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите цифры для поиска контактов: ");
        String digits = scanner.nextLine();
        System.out.print(contacts.stream()
                .filter(contact -> contact.getPhone().contains(digits))
                .map(Contact::getName)
                .sorted()
                .collect(Collectors.joining(", ",contacts.stream()
                        .filter(contact -> contact.getPhone().contains(digits))
                        .count() + " контактов зовут: ",".")));

    };
}
