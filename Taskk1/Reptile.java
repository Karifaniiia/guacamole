package com.example.demo;

public abstract class Reptile extends Animal{
    public static int count = 0;
    private int age;

    public Reptile(String name, int maxRunDist, int maxSwimDist, int age) {
        super(name, maxRunDist, maxSwimDist);
        this.age = age;
        count++;
    }

    public void lifespan(){
        System.out.println("Продолжительность жизни " + this.name + " - " + this.age + " лет.");
}
}
