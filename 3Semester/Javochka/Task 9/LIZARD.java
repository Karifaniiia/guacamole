package org.example;

import java.util.Date;

@Table(title = "LIZARD1")
public class LIZARD {

    public LIZARD(String name, int age, int lifeYears, Date date) {
        this.name = name;
        this.age = age;
        this.lifeYears = lifeYears;
        this.date=date;
    }
    @Column
    public String name;

    @Column
    public int age;

   // @Column
    public int lifeYears;

 // @Column
    public Date date;

    @Column
    public Color color;

    public enum Color {
        BlUE, RED, GREEN;
    }

//public class getColor(Color color){
//        this.Color = color;
//}

}
