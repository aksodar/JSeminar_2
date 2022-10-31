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
        int[] index = new int[]{3,2,1};

        Logger log = Logger.getLogger(Task0.class.getName());
        Task1 t = new Task1();

        String output = t.shuffle(s, index);
        if (output != "") {log.info(output);}
        else {log.warning("bad inputs");}

    }

    public String shuffle(final String s, final int[] index){
        if (s.length()!= index.length) {return "";}
        String res = "";
        for (int i : index) {
            res += String.format("%s",s.toCharArray()[i-1]);
        }
        return res;
    }

}
