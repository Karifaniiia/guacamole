package com.example.zadanie2.transport;
public class MainApp {
    public static void main(String[] args) {
        Participant[] participants = {
                new Human(3, 350, "Elisei"),
                new Robot(5, 1000, "Valli"),
                new Cat(1, 70, "Barsik"),
                new Human(5, 300, "Arseniy"),
                new Human(1, 550, "Ruslan"),
        };

        Let[] lets = {
                new Wall(HeightWall.LOW),
                new Wall(HeightWall.HIGH),
                new Wall(HeightWall.HIGH),
                new RunningRoad(LeightRoad.LOW),
                new RunningRoad(LeightRoad.MEDIUM),
                new Wall(HeightWall.HIGH),
                new RunningRoad(LeightRoad.HIGH),
        };

      for(Participant i:participants)
      {
          for (Let n : lets) {
                if (!n.isCan(i))
                    break;
            }
        }
    }
}

