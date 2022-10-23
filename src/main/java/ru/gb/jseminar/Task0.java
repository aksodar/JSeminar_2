package ru.gb.jseminar;

import java.util.logging.Logger;

public class Task0 {

    // Посчитайте сколько драгоценных камней в куче обычных камней
    // Пример:
    // jewels = “aB”, stones = “aaaAbbbB”
    // Результат в консоль ”a3B1”
    public static void main(String[] args) {
        Task0 task = new Task0();
        Logger log = Logger.getLogger(Task0.class.getName());

        // log.warning("WARNING");
        // log.severe("ERROR");
        // log.info("INFO");
        String jewels = "aB";
        String stones = "aaaAbbbbB";
        log.info(task.findJewelsInStones(jewels, stones));
        // System.out.println(task.findJewelsInStones(jewels, stones));

    }

    public String findJewelsInStones(String jewels, String stones) {
        String result = "";
        int jewelsCount = 0;
        for (char element : jewels.toCharArray()) {
            for (char st : stones.toCharArray()) {
                if (st == element) {
                    jewelsCount++;
                }
                // result = element + Integer.toString(jewelsCount);
            }
            result += element + Integer.toString(jewelsCount);
            jewelsCount = 0;

        }

        return result;
    }

}
