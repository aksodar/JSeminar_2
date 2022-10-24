package ru.gb.jseminar;

import java.util.logging.Logger;

public class Task0 {

    // Посчитайте сколько драгоценных камней в куче обычных камней
    // Пример:
    // jewels = “aB”, stones = “aaaAbbbB”
    // Результат в консоль ”a3B1”
    public static void main(String[] args) {
        Task0 task0 = new Task0();
        String jewels = "aB";
        String stones = "aaaAbbbB";
        Logger log = Logger.getLogger(Task0.class.getName());
        log.info(task0.findJewelsInStones(jewels, stones));
//        log.info("Hello");
//        log.severe("ERROR");
//        log.info("INFO");

    }

    public String findJewelsInStones(String jewels, String stones) {
        int count = 0;
        String result = "";
        for (char jewel: jewels.toCharArray()) {
            for (char stone: stones.toCharArray()) {
                if (jewel == stone) {
                    count ++;
                }
            }
            result += jewel + Integer.toString(count);
            count = 0;
        }
        return result;
    }
}
