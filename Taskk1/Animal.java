package com.example.demo;

public class Animal {
    private String name;
    private int age;
    private int maxRunDist;
    private int maxSwimDist;
    static int count = 0;

    public Animal(String name, int age, int maxRunDist, int maxSwimDist) {
        this.name = name;
        this.age = age;
        this.maxRunDist = maxRunDist;
        this.maxSwimDist = maxSwimDist;
        count++;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public void run(int dist) {
        if (dist <= this.maxRunDist) {
            System.out.println(this.name + "пробежал дистанцию в " + dist + "метров.");
        } else {
            System.out.println(this.name + "не справился с дистанцией по бегу.");
        }
    }
        public void swim (int swimDist) {
            if (swimDist <= this.maxSwimDist) {
                System.out.println(this.name + "проплыл дистанцию в " + swimDist + "метров.");
            } else {
                System.out.println(this.name + "не справился с дистанцией по плаванью.");
            }
        }
}
