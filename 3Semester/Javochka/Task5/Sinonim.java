package com.example.zadanie5;
import java.util.*;

public class Sinonim {

    private final Map<String, TreeSet<String>> dict;
    public Sinonim() {
        dict = new TreeMap<>();
      //  dict.values()
    }

    public void add (String word, String sinonim) {
        if (dict.containsKey(word)) {
            TreeSet<String> s = dict.get(word);
            if (s.contains(sinonim)) {
                System.out.println("Синоним " + sinonim + " уже существует для слова " + word);
            } else {
                s.add(sinonim);
            }
        } else {
            TreeSet<String> sinonimSet = new TreeSet<>();
            sinonimSet.add(sinonim);
            dict.put(word, sinonimSet);
        }

//        for (TreeSet<String> s : dict.values()) {
//            if (s.contains(sinonim)) {
//                System.out.println("Синоним " + sinonim + " существует для слова " + word);
//            }
//        } if (dict.containsKey(word)) {
//            dict.get(word).add(sinonim);
//        } else {
//            TreeSet<String> sinonimSet = new TreeSet<>();
//            sinonimSet.add(sinonim);
//            dict.put(word, sinonimSet);
//        }

    }

    public String get(String word) {
        TreeSet<String> s = dict.get(word);
        if (s != null && !s.isEmpty()) {
            return String.join(", ", s);
        } else {
            return ("Синонимов к слову нет!");
        }
    }

    public void printAll() {
        System.out.println(dict.entrySet());
    }
}
