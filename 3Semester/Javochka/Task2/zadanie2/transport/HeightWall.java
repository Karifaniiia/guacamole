package com.example.zadanie2.transport;

public enum HeightWall {
    LOW("Низкая", 1),MEDIUM("Средняя", 5), HIGH("Высокая", 10);
    private final String title;
    private final int height;
    HeightWall(String title, int height) {
        this.title = title;
        this.height = height;
    }

    public String getTitle() {
        return title;
    }

    public int getHeight() {
        return height;
    }
}
