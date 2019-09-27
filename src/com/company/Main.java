package com.company;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        menu();
    }

    private static void menu(){
        Scanner in = new Scanner(System.in);
        int choice = 0;
        int len;
        try {
            System.out.println("Введите количество элементов массива");
            len = in.nextInt();
            Array array = new Array(len);
            while (choice != 7) {
                System.out.print("Операции над массивом:\n" +
                        "1. Заполение массива с консоли\n" +
                        "2. Случайное заполнение массива\n" +
                        "3. Вывод массива\n" +
                        "4. Вывод массива с конца\n" +
                        "5. Сдвиг влево на N\n" +
                        "6. Сортировка\n" +
                        "7. Выход\n");
                boolean check = true;
                while (check) {
                    System.out.println("Что Вы хотите сделать? ");
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
                switch (choice) {
                    case 1:
                        array.consolInput();
                        break;
                    case 2:
                        array.randInput();
                        break;
                    case 3:
                        System.out.println(array.consolOutput());
                        break;
                    case 4:
                        System.out.println(array.consolOutputReverse());
                        break;
                    case 5:
                        System.out.print("Введите N: ");
                        array.loopShift(in.nextInt());
                        System.out.println(array.consolOutput());
                        break;
                    case 6:
                        array.sorting();
                        System.out.println(array.consolOutput());
                        break;
                    case 7:
                        return;
                    default:
                        System.out.println("Нету такого объекта");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        in.close();
    }
}
