package com.example.zadanie7;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;


public class Car implements Runnable {
        private static int CARS_COUNT;
        private static boolean winner;
        private static final Car[] winners = new Car[3];
        private static final Object lock = new Object();
        public static AtomicInteger finishedCars = new AtomicInteger(0);
      
        static {
            CARS_COUNT = 0;
        }

        private Race race;
        private int speed;
        private String name;
        private CyclicBarrier cb;

        public String getName() {
            return name;
        }

        public int getSpeed() {
            return speed;
        }

        public Car(Race race, int speed, CyclicBarrier cb) {
            this.race = race;
            this.speed = speed;
            CARS_COUNT++;
            this.name = "Участник № " + CARS_COUNT;
            this.cb = cb;

        }

        public void run() {
            try {
                System.out.println(this.name + " готовится");
                Thread.sleep(500 + (int) (Math.random() * 800));
                System.out.println(this.name + " готов");
                cb.await();
                for (int i = 0; i < race.getStages().size(); i++) {
                    race.getStages().get(i).go(this);
                }
                finishedCars.incrementAndGet();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (finishedCars.get() <= 3) MainApp.winners.add(this.name);

        }

