package com.example.zadanie2.transport;

public  class Cat implements Participant{
    int maxHeight;
    int maxLenght;
    String name;

    public Cat(int maxHeight, int maxLenght, String name) {
        this.maxHeight = maxHeight;
        this.maxLenght = maxLenght;
        this.name = name;
    }

    public boolean run(int dist) {
        if (dist <= maxLenght) {
            System.out.println(this.name + " пробежал " + dist + " метров");
            return true;
        }
        else {System.out.println(this.name + " не смог пробежать " + dist + " метров - выбывает");
            return false;}

    }

    public boolean jump(int height) {
        if (height<= maxHeight) {
            System.out.println(this.name+ " перепрыгнул " + height  +" метров");
            return true;
        }
        else {
            System.out.println(this.name+ " не смог перепрыгнуть " + height  +" метров - выбывает");
            return false;
        }
    }
}
