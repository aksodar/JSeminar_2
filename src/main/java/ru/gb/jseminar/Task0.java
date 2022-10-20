package ru.gb.jseminar;

import java.util.logging.Logger;

public class Task0 {

    // Посчитайте сколько драгоценных камней в куче обычных камней
    // Пример:
    // jewels = “aB”, stones = “aaaAbbbB”
    // Результат в консоль ”a3B1”
    public static void main(String[] args) {
        Task0 task = new Task0();
        String jewels = "aBAcd";
        String stones = "aaaAbbbBccccD";
        Logger log = Logger.getLogger(Task0.class.getName());
        log.info(task.findJewelsInStones(jewels,stones));
    }

    public String findJewelsInStones(String jewels, String stones) {
        String finder = "";
        StringBuilder res = new StringBuilder();
        int counter = 0;
        for (int i = 0; i < jewels.length(); i++) {
            for (int j = 0; j < stones.length(); j++) {
                if (jewels.charAt(i) == stones.charAt(j)) {
                    counter++;
                }
                finder = jewels.charAt(i) + Integer.toString(counter);
            }
            counter = 0;
            res.append(finder);
        }
        return res.toString();
    }

}
