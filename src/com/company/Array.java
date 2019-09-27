package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Array {
    private long[] arr;
    private int len;

    public Array(int len) throws Exception {
        if (len <= 0) throw new Exception(new String("Количество элементов должно быть больше нуля"));
        this.len = len;
        arr = new long[this.len];
    }

    public void consolInput() {
        System.out.println("Введите " + len + " чисел");
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < len; i++) {
            boolean check = true;
            while (check) {
                System.out.print("Элемент №" + Integer.toString(i) + ": ");
                if (in.hasNextLong())
                    arr[i] = in.nextLong();
                else {
                    System.out.println("Допускается только long.");
                    in.next();
                    continue;
                }
                check = false;
            }
        }
        in.close();
    }

    public void randInput() {
        for (int i = 0; i < len; i++)
            arr[i] = (long) (Math.random()*(200)) - 100;
    }

    public String consolOutput() { return Arrays.toString(arr); }

    public String consolOutputReverse() {
        String arrn = "[" + Long.toString(arr[len - 1]);
        for (int i = len - 2; i >= 0; i--)
            arrn += ", " + Long.toString(arr[i]);
        return arrn + "]";
    }

    public void loopShift(int k) {
        long c;
        for (int i = 0; i < k; i++)
            for (int j = 0; j < len-1; j++) {
                c = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = c;
            }
    }

    public void sorting() {
        for (int i = 0; i < len; i++)
            if (arr[i] > 0)
                for (int j = i; j > 0; j--) {
                    if (arr[j - 1] > 0) break;
                    long c = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = c;
                }
        for (int i = len - 1; i >= 0; i--)
            if (arr[i] == 0)
                for (int j = i; j < len-1; j++) {
                    if (arr[j + 1] == 0) break;
                    long c = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = c;
                }
    }
}
