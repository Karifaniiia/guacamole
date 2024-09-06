package com.example.demo;

public class Lizard extends Reptile{
   public static int count = 0;
   public Lizard(String name, int maxRunDist, int maxSwimRun,int age){
       super(name,maxRunDist,maxSwimRun,age);
       count++;
   }

}
