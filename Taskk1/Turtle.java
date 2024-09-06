package com.example.demo;

public class Turtle extends Reptile{
public static int count = 0;
public Turtle(String name, int maxRunDist,int maxSwimDist,int age){
    super(name,maxRunDist,maxSwimDist,age);
    count++;
}
}
