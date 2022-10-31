package ru.gb.jseminar;

import java.util.logging.Logger;

public class Task0 {

    // Посчитайте сколько драгоценных камней в куче обычных камней
    // Пример:
    // jewels = “aB”, stones = “aaaAbbbB”
    // Результат в консоль ”a3B1”
    public static void main(String[] args) {
        String jewels = "aB";
        String stones = "aaaAbbbB";
        Task0 task = new Task0();
        Logger log = Logger.getLogger(Task0.class.getName());
        log.info(task.findJewelsInStones(jewels, stones));
    }

    public String findJewelsInStones(String jewels, String stones) {
        String result = "";
        for (char jewel: jewels.toCharArray()) {
            int countJewel = 0;
            for (char stone: stones.toCharArray()) {
                if (jewel == stone) {
                    countJewel++;
                }
            }
            result += jewel + Integer.toString(countJewel);
        }
        return result;
    }

}
