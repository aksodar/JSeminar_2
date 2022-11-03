package ru.gb.jseminar;

import java.util.Scanner;
import java.util.logging.Logger;

public class Task1 {

    // Вам дается строка S и целочисленный массив индексов int index[s.length].
    // Напишите программу, которая перетасует символы в S таким образом,
    // что символ c i-й позиции переместится на индекс index[i] в результирующей строке.
    //
    // Пример: s = “cba”, index = [3,2,1] result “abc”
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Logger log = Logger.getLogger(Task1.class.getName());
        log.info("Введите строку");
        String s = sc.nextLine();
        int[] index = new int[s.length()];
        Task1 task = new Task1();
        log.info("Вводите числа от 0 до " + (s.length() - 1));
        index = task.FillArray(index);
        log.info(task.shuffle(s, index));
        sc.close();
    }

    public String shuffle(final String s, final int[] index){
        String res = "";
        for (int j : index) {
            res += s.charAt(j);
        }
        return res;
    }

    public int[] FillArray(int[] arr) {
        Scanner sc1 = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc1.nextInt();
        }
        sc1.close();
        return arr;
    }
}
