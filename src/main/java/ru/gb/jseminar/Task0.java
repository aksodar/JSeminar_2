package ru.gb.jseminar;

import java.util.Scanner;
import java.util.logging.Logger;

public class Task0 {

    // Посчитайте сколько драгоценных камней в куче обычных камней
    // Пример:
    // jewels = “aB”, stones = “aaaAbbbB”
    // Результат в консоль ”a3B1”
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String jewels = sc.nextLine(), stones = sc.nextLine();
        sc.close();
        Logger log = Logger.getLogger(Task0.class.getName());
        Task0 task0 = new Task0();
        log.info(task0.findJewelsInStones(jewels, stones));
    }

    public String findJewelsInStones(String jewels, String stones) {
        String res = "";
        int count = 0;
        for (int i = 0; i < jewels.length(); i++) {
            res += jewels.charAt(i);
            for (int j = 0; j < stones.length(); j++) {
                if (jewels.charAt(i) == stones.charAt(j)) {
                    count++;
                }
            }
            res += count;
            count = 0;
        }
        return res;
    }

}
