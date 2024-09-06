package com.example.demo;

public class Cat extends Animal {
    private static final int catMaxSwimDist = 0;
    public static int count = 0;
    public Cat(String name, int age,  int maxRunDist){
        super(name,age,maxRunDist, catMaxSwimDist);
        count++;
    }
}
