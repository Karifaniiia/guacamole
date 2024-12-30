package org.example;

import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        LIZARD LIZARD = new LIZARD("Джек", 13, 25,  new Date(1996-1900,12,3));
        LIZARD LIZARD2 = new LIZARD("Изольда", 2, 15, new Date(2014-1900,7,27));
        LIZARD LIZARD3 = new LIZARD("Петр", 9, 32, new Date(2000-1900,3,12));
        LIZARD LIZARD4 = new LIZARD("Yaric", 1, 20, new Date(2024-1900,11,1));
        LIZARD.color = org.example.LIZARD.Color.BlUE;
        LIZARD2.color = org.example.LIZARD.Color.RED;
        LIZARD3.color = org.example.LIZARD.Color.GREEN;
        LIZARD4.color = org.example.LIZARD.Color.RED;

        Requests.createTable(LIZARD);
        Requests.insertIntoTable(LIZARD);
        Requests.insertIntoTable(LIZARD2);
        Requests.insertIntoTable(LIZARD3);
        Requests.insertIntoTable(LIZARD4);


    }

}