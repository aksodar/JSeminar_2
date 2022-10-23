package ru.gb.jseminar;

import java.util.logging.Logger;

public class Task0 {

    // Посчитайте сколько драгоценных камней в куче обычных камней
    // Пример:
    // jewels = “aB”, stones = “aaaAbbbB”
    // Результат в консоль ”a3B1”
    public static void main(String[] args) {
        Task0 t0 = new Task0();
        Logger log = Logger.getLogger(Task0.class.getName());
        String jewels = "aB";
        String stones = "aaaAbbbB";
        log.info(t0.findJewelsInStones(jewels, stones));
//        System.out.println(t0.findJewelsInStones(jewels, stones));
    }

    public String findJewelsInStones(String jewels, String stones) {
        StringBuilder result = new StringBuilder();
        int count = 0;

        for (int i = 0; i < jewels.length(); i++) {
            for (char stone : stones.toCharArray()) {
                if (jewels.charAt(i) == stone) {
                    count++;
                }

            }
            String countStr = Integer.toString(count);
            result.append(jewels.charAt(i)).append(countStr);
            count = 0;
        }

        return result.toString();
    }

}
