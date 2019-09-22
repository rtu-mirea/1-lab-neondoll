package com.company;

import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;

public class Array {
    private long[] arr;
    private int len;

    Array() {
        Scanner in = new Scanner(System.in);
        boolean check = true;
        int choice = -1;
        while (check) {
            System.out.println("\nКак вводить массив? (0 - с клавиатуры, 1 - генератор):");
            if (in.hasNextInt()){
                choice = in.nextInt();
            }
            else{
                System.out.print("Допускается только int.");
                in.next();
                continue;
            }
            check = false;
        }

        len = 10;
        arr = new long[len];

        if (choice == 0) {
            inArray();
        }
        else if (choice == 1) {
            inArrayRandom();
        }
    }

    public void inArray() {
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < len; i++) {
            boolean check = true;
            while (check) {
                System.out.print("Элемент №" + Integer.toString(i) + ": ");
                if (in.hasNextLong()) {
                    arr[i] = in.nextInt();
                } else {
                    System.out.println("Допускается только long.");
                    in.next();
                    continue;
                }
                check = false;
            }
        }
    }

    public void inArrayRandom() {
        for (int i = 0; i < len; i++) arr[i] = (long) (Math.random()*(200)) - 100;
    }

    public String outArrayLeftOnRight() { return Arrays.toString(arr); }

    public String outArrayRightOnLeft() {
        String arrn = "[" + Long.toString(arr[len - 1]);
        for (int i = len - 2; i >= 0; i--) {
            arrn += ", " + Long.toString(arr[i]);
        }
        return arrn + "]";
    }

    public void loopShiftArray(int k) {
        long c;
        for (int i = 0; i < k; i++) {
            c = arr[0];
            for (int j = 1; j < len; j++) arr[j-1] = arr[j];
            arr[len-1] = c;
        }
    }

    public void sorting() {
        for (int i = 0; i < len; i++) {
            if (arr[i] > 0) {
                for (int j = i; j > 0; j--) {
                    if (arr[j - 1] > 0) break;
                    long c = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = c;
                }
            }
        }
        for (int i = len - 1; i >= 0; i--) {
            if (arr[i] == 0) {
                for (int j = i; j < len-1; j++) {
                    if (arr[j + 1] == 0) break;
                    long c = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = c;
                }
            }
        }
    }
}
