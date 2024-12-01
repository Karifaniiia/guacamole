package com.example.zadanie7;
import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    Semaphore s = new Semaphore(MainApp.TUNNEL_CONSTRAINT);

    public Tunnel() {
        this.length = 10;
        this.description = "Тоннель " + length + " метров";
    }

    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                s.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 800);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                s.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}