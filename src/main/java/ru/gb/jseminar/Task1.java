package ru.gb.jseminar;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;


public class Task1 {

    // Вам дается строка S и целочисленный массив индексов int index[s.length].
    // Напишите программу, которая перетасует символы в S таким образом,
    // что символ c i-й позиции переместится на индекс index[i] в результирующей строке.
    //
    // Пример: s = “cba”, index = [3,2,1] result “abc”
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите строку : ");
        String str = iScanner.nextLine();
        int [] arr = new int [str.length()];
        int i = 1;
        Random r = new Random();
        int k = r.nextInt(0, arr.length);
        arr [0] = k;
             
        while (i < arr.length){
            boolean flag = false;
            int number = r.nextInt(0, arr.length);
            for (int j = 0; j < i; j++) {
                if (arr[j] == number){
                    flag = true;
                }
            } 
                 if (flag == false){
                    arr[i] = number;
                    i++;
                 } 
        }
        
        Logger log = Logger.getLogger(Task1.class.getName());
        log.info(task1.shuffle(str, arr));

    }

    public String shuffle(final String s, final int[] index){
        char [] arr = s.toCharArray();
        String rez = "";
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < index.length; j++) {
                if (i == index[j]){
                    rez = new StringBuilder(rez).append(arr[j]).toString();
                }
            }
        }
        return rez;
    }

}
