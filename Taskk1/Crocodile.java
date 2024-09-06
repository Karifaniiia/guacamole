package com.example.demo;

public class Crocodile extends Reptile{
    public static int count = 0;
    public static final int years = 200;
    public Crocodile(String name, int age, int maxRunDist, int maxSwimDist) {
        super(name, age, maxRunDist, maxSwimDist, years);
        count++;
    }
}
