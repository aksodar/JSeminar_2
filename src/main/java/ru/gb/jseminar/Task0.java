package ru.gb.jseminar;

import java.util.logging.Logger;

public class Task0 {

    // Посчитайте сколько драгоценных камней в куче обычных камней
    // Пример:
    // jewels = “aB”, stones = “aaaAbbbB”
    // Результат в консоль ”a3B1”
    public static void main(String[] args) {
        Task0 task0 = new Task0();
        Logger log = Logger.getLogger(Task0.class.getName());
        log.info("HELLO");
        String jewels = "aB";
        String stones = "aaaAbbbB";
        String result = task0.findJewelsInStones(jewels, stones);
        log.warning(result);
    }

    public String findJewelsInStones(String jewels, String stones) {
        char[] jewels_arr = jewels.toCharArray();
        char[] stones_arr = stones.toCharArray();
        String res = "";
        for (char jewel : jewels_arr) {
            int count = 0;
            for (char stone : stones_arr) {
                if (jewel == stone) {
                    count++;
                }
            }
            res += String.format("%s%d", jewel, count);
        }
        return res;
    }

}
