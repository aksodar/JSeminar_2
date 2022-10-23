package ru.gb.jseminar;

import java.util.logging.Logger;

public class Task1 {

    // Вам дается строка S и целочисленный массив индексов int index[s.length].
    // Напишите программу, которая перетасует символы в S таким образом,
    // что символ c i-й позиции переместится на индекс index[i] в результирующей
    // строке.
    //
    // Пример: s = “cba”, index = [3,2,1] result “abc”
    public static void main(String[] args) {
        Task1 task = new Task1();
        String str = "cba";
        int[] arr = new int[] { 3, 2, 1 };
        Logger log = Logger.getLogger(Task1.class.getName());
        log.info(task.shuffle(str, arr));

    }

    public String shuffle(final String s, final int[] index) {
        String result = "";
        char[] text = s.toCharArray();
        for (int item : index) {
            // System.out.println(item);
            result += text[item - 1];
        }

        return result;
    }

}
