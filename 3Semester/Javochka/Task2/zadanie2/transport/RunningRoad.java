package com.example.zadanie2.transport;

public class RunningRoad implements Let{
    String name;

    public RunningRoad(LeightRoad roadLeight) {
        this.name=roadLeight.getTitle();
        this.roadLeigth = roadLeight.getLeight();
    }
    int roadLeigth;

    public boolean isCan(Participant participant) {
        return participant.run(roadLeigth);
    }}
