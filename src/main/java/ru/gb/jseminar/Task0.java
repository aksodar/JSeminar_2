package ru.gb.jseminar;


import java.util.Scanner;
import java.util.logging.Logger;

public class Task0 {

    // Посчитайте сколько драгоценных камней в куче обычных камней
    // Пример:
    // jewels = “aB”, stones = “aaaAbbbB”
    // Результат в консоль ”a3B1”
    public static void main(String[] args) {
        Task0 t = new Task0();
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("jewels = ");
        String jewels = iScanner.nextLine();
        System.out.printf("stones = ");
        String stones = iScanner.nextLine();
        iScanner.close();



        Logger log = Logger.getLogger(Task0.class.getName());
        //log.warning("Hello");
        //log.severe("ERROR");
        log.info(t.findJewelsInStones(jewels, stones));

    }

    public String findJewelsInStones(String jewels, String stones) {
        int count = 0;
        String result = "";
        for (char jewel: jewels.toCharArray()) {
            for (char stone : stones.toCharArray()) {
                if (jewel == stone) {
                    count++;
                }
            }
            result = result + jewel + Integer.toString(count);
            count = 0;
        }
        return result;
    }

}
