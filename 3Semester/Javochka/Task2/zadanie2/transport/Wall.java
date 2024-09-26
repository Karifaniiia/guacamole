package com.example.zadanie2.transport;

public class Wall implements Let{
    private int wallHeight;
    public Wall(HeightWall wallHeight) {
        this.height = wallHeight.getHeight();
        this.title = wallHeight.getTitle();

    }
    int height;
    String title;

    public boolean isCan(Participant participant) {
        return participant.jump(height);
    }
}
