package com.example.demo;

public class Lizard extends Reptile{
   public static int count = 0;
   public static final int years = 10;
   public Lizard(String name, int age, int maxRunDist, int maxSwimRun){
       super(name,age,maxRunDist,maxSwimRun,years);
       count++;
   }

}
