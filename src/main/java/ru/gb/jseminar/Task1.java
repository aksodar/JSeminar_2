package ru.gb.jseminar;

import java.util.Arrays;
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
        Logger log = Logger.getLogger(Task1.class.getName());
        String s = "cbasdf";
        int [] index = {1, 5, 3, 0, 4, 2};
        String result = task1.shuffle(s, index);
        log.info(result);

    }

    public String shuffle(final String s, final int[] index){
        char [] res = new char[index.length];
        for (int i=0; i<s.length(); i++){
            res[index[i]] = s.charAt(i);
        }
        String result = Arrays.toString(res);
        return result;
    }

}
