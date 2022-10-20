package ru.gb.jseminar;
import java.util.logging.Logger;
public class Task0 {

    // Посчитайте сколько драгоценных камней в куче обычных камней
    // Пример:
    // jewels = “aB”, stones = “aaaAbbbB”
    // Результат в консоль ”a3B1”
    public static void main(String[] args) {
        Task0 task0 = new Task0();
        String jewels = "aB", stones = "aaaAbbbB";
        String result = task0.findJewelsInStones(jewels, stones);
        Logger log = Logger.getLogger(Task0.class.getName());
        log.info(result);
    }

    public String findJewelsInStones(String jewels, String stones) {
        String result = " ";
        for (char jewel : jewels.toCharArray()) {
            int count = 0;
            for (char stone : stones.toCharArray()) {
                if (jewel == stone) count +=1;
            }
            result += String.valueOf(jewel);
            result += count;
        }
        return result;
    }
}
