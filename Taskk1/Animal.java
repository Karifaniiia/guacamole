package com.example.demo;

public class Animal {
    protected String name;
    private int maxRunDist;
    private int maxSwimDist;
    static int count = 0;

    public Animal(String name, int maxRunDist, int maxSwimDist) {
        this.name = name;
        this.maxRunDist = maxRunDist;
        this.maxSwimDist = maxSwimDist;
        count++;
    }

    public String getName() {

        return name;
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
