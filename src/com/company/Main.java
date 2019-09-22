package com.company;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        menu();
    }

    private static void menu(){
        Scanner in = new Scanner(System.in);
        int choice = -1;

        Array arr = new Array();

        while (choice != 0) {
            System.out.print("\n1 - Вывод массива\n" +
                    "2 - Вывод массива с конца\n" +
                    "3 - Сдвиг влево на N\n" +
                    "4 - Сортировка\n" +
                    "0 - Выход\n");
            boolean check = true;
            while (check) {
                System.out.println("Что Вы хотите сделать?: ");
                if (in.hasNextInt()){
                    choice = in.nextInt();
                }
                else{
                    System.out.println("Допускается только int.");
                    in.next();
                    continue;
                }
                check = false;
            }
            if (choice == 1) {
                System.out.println(arr.outArrayLeftOnRight());
            }
            else if (choice == 2) {
                System.out.println(arr.outArrayRightOnLeft());
            }
            else if (choice == 3) {
                System.out.print("Введите N: ");
                arr.loopShiftArray(in.nextInt());
                System.out.println(arr.outArrayLeftOnRight());
            }
            else if (choice == 4) {
                arr.sorting();
                System.out.println(arr.outArrayLeftOnRight());
            }
        }
    }
}
