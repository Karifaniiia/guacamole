package com.example.demo;

public class Crocodile extends Reptile{
    public static int count = 0;
    public Crocodile(String name, int maxRunDist, int maxSwimDist,int age) {
        super(name, maxRunDist, maxSwimDist,age);
        count++;
    }
}
