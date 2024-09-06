package com.example.demo;

public class MainApp {
    public static void main(String[]args){
        Animal[] animals = {new Cat ("Barsik ",5,200), new Cat ("Murzic ",2,250), new Dog ("Recsik ", 4, 500, 10),
                new Tiger ("Tigrulia ", 6, 1000, 500),new Turtle("Gloria ", 87,10,100 ),
                new Lizard("Kevin ", 60, 5,1),new Crocodile("Dzek ", 10,40,8)};
        for (Animal a: animals) {
            a.run(220);
            a.swim(10);
            System.out.println();
        }
        for (int i = 4; i < 7; i++) {
            ((Reptile) animals[i]).lifespan();
        }
        System.out.println("Количество котиков: " + ((Cat) animals[0]).count);
        System.out.println("Количество собак : " + ((Dog) animals[2]).count);
        System.out.println("Количество тигруль : " + ((Tiger) animals[3]).count);
        System.out.println("Количество черепах : " + ((Turtle) animals[4]).count);
        System.out.println("Количество ящриц : " + ((Lizard) animals[5]).count);
        System.out.println("Количество крокодилов : " + ((Crocodile) animals[6]).count);
        System.out.println("Всего животных : " + Animal.count);

    }
}
