package com.example.zadanie3;

public class MyConsonantsException extends RuntimeException {
    private int i;
    private int j;
    private String n;
    public MyConsonantsException(int i, int j, String n) {
        super("В массиве согласная буква " + n + " Строка " + (i + 1) + " столбец " + (j + 1));
        this.i = i;
        this.j = j;
        this.n = n;
    }
}
