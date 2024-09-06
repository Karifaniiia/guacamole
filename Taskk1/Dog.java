package com.example.demo;

public class Dog extends Animal{
    public static int count = 0;
    public Dog (String name, int age, int maxRunDist, int maxSwimDist){
        super(name,age,maxRunDist,maxSwimDist);
        count++;
    }
}
