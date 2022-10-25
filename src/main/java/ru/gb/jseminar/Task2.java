package ru.gb.jseminar;

import java.io.*;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Task2 {

    //Напишите программу, которая принимает с консоли число в формате byte и записывает его в файл ”result.txt”.
    //Требуется перехватить все возможные ошибки и вывести их в логгер.
    //
    //После написания, попробуйте подать на вход числа 100 и 200 и проследите разницу в результате
    public static void main(String[] args) {
        try {
            Scanner iScanner = new Scanner(System.in);
            byte number = iScanner.nextByte();
            Task2 tk = new Task2();
            tk.ImportByte(number);
        } catch (InputMismatchException e){
            Logger log = Logger.getLogger(Task0.class.getName());
            log.warning("Перебор типа!");
        }

    }

    public byte ImportByte(byte number) {

        try {
            FileWriter wr = new FileWriter("result.tx");
            BufferedWriter bfw = new BufferedWriter(wr);
            bfw.write(number);
            bfw.flush();
            wr.close();

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return number;
    }

}
