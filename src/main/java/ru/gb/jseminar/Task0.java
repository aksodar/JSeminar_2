package ru.gb.jseminar;

import java.util.logging.Logger;

public class Task0 {

    // Посчитайте сколько драгоценных камней в куче обычных камней
    // Пример:
    // jewels = “aB”, stones = “aaaAbbbB”
    // Результат в консоль ”a3B1”
    public static void main(String[] args) {
        Task0 t1 = new Task0();
        String j = "aB";
        String s = "aaaAbbbB";
        Logger log = Logger.getLogger(Task0.class.getName());
        log.info(t1.findJewelsInStones(j, s));

    }

    public String findJewelsInStones(String jewels, String stones) {
        String result = "";
        int count = 0;
        for (int i = 0; i < jewels.length(); i++) {
            for (int j = 0; j < stones.length(); j++) {
                if (jewels.charAt(i) == stones.charAt(j)){
                    count++;
                }
            }
            result = new StringBuilder(result).append(count).append(jewels.charAt(i)).toString();
            
        }

        return result;
    }

}
