package ru.gb.jseminar;

import java.util.logging.Logger;

public class Task1 {

    // Вам дается строка S и целочисленный массив индексов int index[s.length].
    // Напишите программу, которая перетасует символы в S таким образом,
    // что символ c i-й позиции переместится на индекс index[i] в результирующей строке.
    //
    // Пример: s = “cba”, index = [3,2,1] result “abc”
    public static void main(String[] args) {
        Logger log = Logger.getLogger(Task1.class.getName());
        Task1 task1 = new Task1();
        String s = "cba";
        int[] index = {3,2,1};

    }

    public String shuffle(final String s, final int[] index){
        String result = "";
        char[] ar = s.toCharArray();
        for (int i = 1 ; i < ar.length; i++){
            int j = index[i];
            result += ar;

        }


        return result;
    }

}
