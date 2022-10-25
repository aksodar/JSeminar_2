package ru.gb.jseminar;

public class Task1 {

    // Вам дается строка S и целочисленный массив индексов int index[s.length].
    // Напишите программу, которая перетасует символы в S таким образом,
    // что символ c i-й позиции переместится на индекс index[i] в результирующей строке.
    //
    // Пример: s = “cba”, index = [2,1,0] result “abc”
    public static void main(String[] args) {
        Task1 ts = new Task1();
        String s = "домовой!";

        int[] index = new int[] {1,3,2,8,6,5,4,7};
        System.out.println(ts.shuffle(s, index));
    }

    public StringBuilder shuffle(final String s, final int[] index) {
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < index.length; i++) {

                result.append(s.charAt(index[i]-1));

            }



        return result;
    }
}
