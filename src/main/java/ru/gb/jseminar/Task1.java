package ru.gb.jseminar;

import java.util.logging.Logger;

public class Task1 {

    // Вам дается строка S и целочисленный массив индексов int index[s.length].
    // Напишите программу, которая перетасует символы в S таким образом,
    // что символ c i-й позиции переместится на индекс index[i] в результирующей строке.
    //
    // Пример: s = “cba”, index = [3,2,1] result “abc”
    public static void main(String[] args) {
        Task1 t = new Task1();
        String s = "cba";
        int[] index = {1, 3, 2};
        Logger log = Logger.getLogger(Task1.class.getName());
        log.info(t.shuffle(s, index));
    }

    public String shuffle(final String s, final int[] index){
        String resultString = "";
        for (int elem: index) resultString = resultString + s.charAt(elem - 1);
        return resultString;
    }

}
