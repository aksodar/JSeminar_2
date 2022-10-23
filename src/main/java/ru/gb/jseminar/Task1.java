package ru.gb.jseminar;

import org.jetbrains.annotations.NotNull;

import java.util.logging.Logger;

public class Task1 {

    // Вам дается строка S и целочисленный массив индексов int index[s.length].
    // Напишите программу, которая перетасует символы в S таким образом,
    // что символ c i-й позиции переместится на индекс index[i] в результирующей строке.
    //
    // Пример: s = “cba”, index = [3,2,1] result “abc”
    public static void main(String[] args) {
        Task1 task = new Task1();
        String s = "cba";
        int[] index = new int [] {3, 2, 1};
        Logger log = Logger.getLogger(Task0.class.getName());
        log.info(task.shuffle(s, index));
    }

    public String shuffle(final String s, final int[] index){
        String [] result = new String[s.length()+1];

        int i = 0;
        for (char ch: s.toCharArray()){

            result[i] = "cba";
            System.out.println(result[i].toString());

        }
        return result.toString();
    }
}
