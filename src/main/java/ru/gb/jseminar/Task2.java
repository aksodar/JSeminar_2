package ru.gb.jseminar;

import java.io.FileWriter;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class Task2 {

    //Напишите программу, которая принимает с консоли число в формате byte и записывает его в файл ”result.txt”.
    //Требуется перехватить все возможные ошибки и вывести их в логгер.
    //
    //После написания, попробуйте подать на вход числа 100 и 200 и проследите разницу в результате
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.printf("Введите число в формате byte: ");
        try {
            byte number = scan.nextByte();
            FileWriter fw = new FileWriter("result.txt");
            fw.write(String.valueOf(number));
            fw.flush();
            fw.close();
        } catch (Exception e) {
            Logger log = Logger.getLogger(Task2.class.getName());
            log.severe("Число должно быть в пределах от -128 до 127!");
        } finally {
            scan.close();
        }
    }

}
