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
        String s = "cba";
        int[] index = new int[] {3, 2, 1};
        String result = task.shuffle(s, index);
        Logger log = Logger.getLogger(Task1.class.getName());
        log.info(result);
    }

    public String shuffle(final String s, final int[] index){
        String[] arrays = new String[s.length()];
        for (int i = 0; i < s.length(); i++) {
            arrays[index[i]-1] = String.valueOf(s.charAt(i));
        }
        String result = String.join("", arrays);
        return result;
    }

}
