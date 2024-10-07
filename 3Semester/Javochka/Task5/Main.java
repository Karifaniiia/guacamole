package com.example.zadanie5;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Базовое задание:\n");
        String[] arrayWord = {"Банан", "Книга", "Машина", "Телефон","Машина","Книга", "Собака", "Банан", "Яблоко", "Ноутбук", "Банан"};
        TreeMap<String, Integer> listWord = new TreeMap<>();
        for (String s: arrayWord) {
            listWord.merge(s, 1, Integer::sum);
        }
        System.out.println(listWord.keySet());
        System.out.println(listWord.entrySet()+ "\n");

        System.out.println("Индивидуальное задание:\n");
        Sinonim s = new Sinonim();
        s.add("Азбука","ялфавит");
        s.add("Машина","Автомобиль");
        s.add("Анализ","Разбор");
        s.add("Секретный","Тайный");
        s.add("Секретный","Скрытный");
        s.add("Секретный","Зашифрованный");
        s.add("Хобби","Увлечение");
        s.add("Хобби","Занятие");
        s.add("Комфорт","Удобство");
        s.add("Диалог","Беседа");
        s.add("Азбука","Букварь");
        s.add("Аука","Букварь");

        System.out.println(s.get("Азбука"));
        s.printAll();
    }
}