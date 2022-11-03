package ru.gb.jseminar;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Task2 {

    //Напишите программу, которая принимает с консоли число в формате byte и записывает его в файл ”result.txt”.
    //Требуется перехватить все возможные ошибки и вывести их в логгер.
    //
    //После написания, попробуйте подать на вход числа 100 и 200 и проследите разницу в результате
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            byte num = sc.nextByte();
            sc.close();
            Task2 t2 = new Task2();
            t2.ByteImport(num);
        }
        catch (InputMismatchException e) {
            Logger log = Logger.getLogger(Task2.class.getName());
            log.warning(("Переполнение типа!"));
        }

    }

    public byte ByteImport(byte number){
        try {
            FileWriter fileW = new FileWriter("result.txt");
            BufferedWriter bfw = new BufferedWriter(fileW);
            bfw.write(number);
            bfw.flush();
            fileW.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } return number;
    }

}
