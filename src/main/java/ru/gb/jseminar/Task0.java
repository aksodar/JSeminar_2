package ru.gb.jseminar;

import com.sun.tools.javac.Main;

import java.util.logging.Logger;

public class Task0 {

     // Посчитайте сколько драгоценных камней в куче обычных камней
    // Пример:
    //jewels = “aB”, stones = “aaaAbbbB”
    // Результат в консоль ”a3B1”
    public static void main(String[] args) {
        Task0 task0 = new Task0();
        String jewels = "aB";
        String stones = "aaaAbbbB";
        Logger logger = Logger.getLogger(Task0.class.getName());
        logger.info(task0.findJewelsInStones(jewels, stones));
    }
    public String findJewelsInStones(String jewels, String stones) {

        int count1 = 0;
        String result = "";
        for (int i = 0; i < jewels.length(); i++) {
            count1 = 0;
            for (int j = 0; j <stones.length() ; j++) {
                if (stones.charAt(j) == jewels.charAt(i)){
                    count1 += 1;
                }

            }
            result +=  jewels.charAt(i) +Integer.toString(count1);
        }
        return result;
    }

}
