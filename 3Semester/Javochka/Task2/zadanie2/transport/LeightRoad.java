package com.example.zadanie2.transport;

public enum LeightRoad {
    LOW("Короткая дистанция", 100), MEDIUM("Средняя дистанция", 500), HIGH("Длинная дистанция", 1000);
    private final String title;
    private final int leight;
    LeightRoad(String title, int leight) {
        this.title = title;
        this.leight = leight;
    }

    public String getTitle() {
        return title;
    }

    public int getLeight() {
        return leight;
    }
}
