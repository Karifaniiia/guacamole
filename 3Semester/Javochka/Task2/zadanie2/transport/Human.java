package com.example.zadanie2.transport;

public class Human implements Participant{
    private final int maxHeight;
    private final int maxLenght;
    String name;
   public static int superJumpCount = 2;

    public Human(int maxHeight, int maxLenght, String name) {
        this.maxHeight = maxHeight;
        this.maxLenght = maxLenght;
        this.name = name;
    }

    public boolean run(int dist) {
        if (dist <= maxLenght) {
            System.out.println(this.name + " пробежал " + dist + " метров");
            return true;
        }
        else {
            System.out.println(this.name + " не смог пробежать "+ dist + " метров - выбывает");
            return false;
        }
    }

    public boolean jump(int height) {
        if (height<= maxHeight) {
            System.out.println(this.name+ " перепрыгнул " + height  +" метров");
            return  true;
        }
        else if (superJumpCount != 0) {
         //   superJump();
            System.out.println(this.name+ " перепрыгнул, используя экстра" );
            superJumpCount --;
            return true;
        }
        else {
            System.out.println(this.name+ " не смог перепрыгнуть " + height  +" метров - выбывает");
            return false;
        }
    }
   /* public void superJump() {
        System.out.println(this.name+ " перепрыгнул, используя экстра" );
        superJumpCount --;*/

    }
