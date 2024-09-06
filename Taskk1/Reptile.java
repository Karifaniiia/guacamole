package com.example.demo;

public abstract class Reptile extends Animal{
    public static int count = 0;
    public String name;
    public int years;
    public Reptile(String name,int age,int maxRunDist, int maxSwimDist, int years){
        super(name,age,maxRunDist,maxSwimDist);
        this.name = name;
        this.years = years;
        count++;
    }
public void lifespan(){
        System.out.println("Продолжительность жизни " + this.name + " - " + this.years + " лет.");
}
}
