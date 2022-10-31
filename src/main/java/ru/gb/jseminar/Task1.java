package ru.gb.jseminar;

import java.util.logging.Logger;

public class Task1 {

    // Вам дается строка S и целочисленный массив индексов int index[s.length].
    // Напишите программу, которая перетасует символы в S таким образом,
    // что символ c i-й позиции переместится на индекс index[i] в результирующей строке.
    //
    // Пример: s = “cba”, index = [3,2,1] result “abc”
    public static void main(String[] args) {
        String s = "cba";
        int[] index = {3,2,1};
        Task1 task = new Task1();
        Logger log = Logger.getLogger(Task1.class.getName());
        log.info(task.shuffle(s, index));
    }

    public String shuffle(final String s, final int[] index){
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            result += s.charAt(index[i] - 1);
        }
        return result;
    }

}
