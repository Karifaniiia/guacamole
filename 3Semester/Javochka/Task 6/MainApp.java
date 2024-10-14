package com.example.zadanie6;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {

        final int size = 60_000_006 ;
        final int half = size / 2;

//        public static void metodOne() {
            float[] array = new float[size];
            Arrays.fill(array, 1.0f);
            long time = System.currentTimeMillis();
            for (int i = 0; i < array.length; i++) {
                array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println(array[0]);
            System.out.println(array[array.length - 1]);
            System.out.println("Время выполнения первого метода: " + (System.currentTimeMillis() - time));
//        }

//        public void methodTwo(){
            float[] arrayTwo = new float[size];
            float[] firstHalf = new float[half];
            float[] secondHalf = new float[half];
            Arrays.fill(arrayTwo, 1.0f);
            long timeTwo = System.currentTimeMillis();
            System.arraycopy(arrayTwo, 0, firstHalf, 0, half);
            System.arraycopy(arrayTwo, half, secondHalf, 0, half);

            Thread thread1 = new Thread(() -> {
                for (int i = 0; i < firstHalf.length; i++) {
                    firstHalf[i] = (float) (firstHalf[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
                System.arraycopy(firstHalf, 0, arrayTwo, 0, firstHalf.length);
            });
            Thread thread2 = new Thread(() -> {
                for (int i = 0; i < secondHalf.length; i++) {
                    secondHalf[i] = (float) (secondHalf[i] * Math.sin(0.2f + (half + i) / 5) * Math.cos(0.2f + (half + i) / 5) * Math.cos(0.4f + (half + i) / 2));
                }
                System.arraycopy(secondHalf, 0, arrayTwo, half, secondHalf.length);
            });
            thread1.start();
            thread2.start();
            try {
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(arrayTwo[0]);
            System.out.println(arrayTwo[arrayTwo.length - 1]);
            System.out.println("Время выполнения второго метода: " + (System.currentTimeMillis() - timeTwo));
//        }

//        public void methodThree(int n) {
        int n = 4; // количесвто потоков
            float[] arrayTree = new float[size];
            Arrays.fill(arrayTree, 1.0f);
            long timeTree = System.currentTimeMillis();
            Thread[] threads = new Thread[n];
            float[][] results = new float[n][];

            int partSize = size / n;
            // остаток данных для 1го потока
            int k = size % n;

            for (int i = 0; i < n; i++) {
                final int startIndex = i * partSize + (i == 0 ? 0 : k);
                final int endIndex = (i == n - 1) ? size : startIndex + partSize + (i == 0 ? k : 0);
                final int index = i;

                int elementsCount = endIndex - startIndex;
                System.out.println("Поток " + (i + 1) + " обрабатывает " + elementsCount + " элементов.");

                threads[i] = new Thread(() -> {
                    float[] subArray = Arrays.copyOfRange(arrayTree, startIndex, endIndex);
                    for (int j = 0; j < subArray.length; j++) {
                        subArray[j] = (float) (subArray[j] * Math.sin(0.2f + (startIndex + j) / 5) * Math.cos(0.2f + (startIndex + j) / 5) * Math.cos(0.4f + (startIndex + j) / 2));
                    }
                    results[index] = subArray;
                });
                threads[i].start();
            }

            try {
                for (Thread thread : threads) {
                    thread.join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < n; i++) {
                int startIndex = i * partSize + (i == 0 ? 0 : k);
                System.arraycopy(results[i], 0, arrayTree, startIndex, results[i].length);
            }
            System.out.println(arrayTree[0]);
            System.out.println(arrayTree[arrayTree.length - 1]);
            System.out.println("Время выполнения третьего метода: " + (System.currentTimeMillis() - timeTree));
        }

    }
//}
