package ru.gb.jseminar;

import java.util.Arrays;
import java.util.logging.Logger;

public class Task1 {

    // Вам дается строка S и целочисленный массив индексов int index[s.length].
    // Напишите программу, которая перетасует символы в S таким образом,
    // что символ c i-й позиции переместится на индекс index[i] в результирующей строке.
    //
    // Пример: s = “cba”, index = [3,2,1] result “abc”
    public static void main(String[] args) {
        Task1 t1 = new Task1();
        Logger log = Logger.getLogger(Task0.class.getName());
        int[] index = new int[] {5,4,3,2,1};
        String s = "abcde";
        log.info(t1.shuffle(s,index));
//        System.out.println(t1.shuffle(s,index));
    }

    public String shuffle(final String s, final int[] index){
        char[] charString = s.toCharArray();
        for (int i = 0; i < charString.length; i++) {
            charString[i] = s.charAt(index[i]-1);
        }
        return Arrays.toString(charString);  // пытался привести к тому же виду, что и входные данные, но окончательно запутался и решил оставить как есть
    }
}
