package ru.gb.jseminar;
import java.util.logging.Logger;

public class Task1 {

    // Вам дается строка S и целочисленный массив индексов int index[s.length].
    // Напишите программу, которая перетасует символы в S таким образом,
    // что символ c i-й позиции переместится на индекс index[i] в результирующей строке.
    //
    // Пример: s = “cba”, index = [3,2,1] result “abc”
    public static void main(String[] args) {
        Task1 task = new Task1();
        String S = "cba";
        int [] index = {3,2,1};
        Logger log = Logger.getLogger(Task1.class.getName());
        log.info(task.shuffle(S, index));

    }

    public String shuffle(final String s, final int[] index){
        char[] result = new char[s.length()+1];
        char [] str = new char[s.length()];
        str = s.toCharArray();
        int i=0;
        for (int unit : index) {
            result[unit-1] = str[i];
            i++;
            }
        String res = new String(result);
        return res;
    }
}
