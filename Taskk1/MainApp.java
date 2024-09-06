package com.example.demo;

public class MainApp {
    public static void main(String[] args) {
        Animal[] animals = {
                new Cat("Barsik ",200),
                new Cat("Murzic ",2),
                new Dog("Recsik ",500, 10),
                new Tiger("Tigrulia ", 1000, 500),
                new Turtle("Gloria ", 100,100,200),
                new Lizard("Kevin ", 12, 1, 12),
                new Crocodile("Dzek ", 200, 8,100)};
        for (Animal a : animals) {
            a.run(220);
            a.swim(10);
            System.out.println();
        }
        for (int i = 4; i < 7; i++) {
            ((Reptile) animals[i]).lifespan();
        }
        System.out.println("Количество котиков: " + Cat.count);
        System.out.println("Количество собак : " + Dog.count);
        System.out.println("Количество тигруль : " + Tiger.count);
        System.out.println("Количество черепах : " + Turtle.count);
        System.out.println("Количество ящриц : " + Lizard.count);
        System.out.println("Количество крокодилов : " + Crocodile.count);
        System.out.println("Всего животных : " + Animal.count);

    }
}

