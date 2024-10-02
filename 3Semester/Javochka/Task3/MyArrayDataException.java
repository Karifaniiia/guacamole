package com.example.zadanie3;

public class MyArrayDataException extends RuntimeException {
    private int i;
    private int j;
    private String n;
    public MyArrayDataException(int i, int j, String n) {
        super("Неверный символ " + n + ". Ошибка в " + (i + 1) + " строке " + (j + 1) + " столбце");
        this.i = i;
        this.j = j;
        this.n = n;
    }
    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
