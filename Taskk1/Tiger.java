package com.example.demo;

public class Tiger extends Animal {
    public static int count = 0;
    public Tiger(String name,int age,int maxRunDist, int maxSwimDist){
        super(name,age,maxRunDist, maxSwimDist);
        count++;
    }
}
