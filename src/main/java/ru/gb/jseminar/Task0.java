package ru.gb.jseminar;

import java.util.logging.Logger;

public class Task0 {

    // Посчитайте сколько драгоценных камней в куче обычных камней
    // Пример:
    // jewels = “aB”, stones = “aaaAbbbB”
    // Результат в консоль ”a3B1”
    public static void main(String[] args) {
        Task0 js = new Task0();
        Logger log = Logger.getLogger(Task0.class.getName());
        String res = js.findJewelsInStones("aB","aaaAbbbB");
        log.info(res);
    }

    public String findJewelsInStones(String jewels, String stones) {
        String res = "";
        for (int i = 0; i < jewels.length(); i++) {
            int count = 0;

            for (char stone : stones.toCharArray()) {
                if (stone==jewels.toCharArray()[i]) {
                    count++;
                }
            }
            res += String.format("%s%s",jewels.toCharArray()[i], count );
        }
        return res;
    }

//        log.severe("ERROR");
//        log.warning("WARNING");
//        log.info("INFO");
//        log.config("CONFIG");
//        log.fine("FINE");
//        log.finer("FINER");
//        log.finest("FINEST");





}
