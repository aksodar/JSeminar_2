package ru.gb.jseminar;


import java.util.InputMismatchException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

public class Task2 {

    //Напишите программу, которая принимает с консоли число в формате byte и записывает его в файл ”result.txt”.
    //Требуется перехватить все возможные ошибки и вывести их в логгер.
    //
    //После написания, попробуйте подать на вход числа 100 и 200 и проследите разницу в результате
    public static void main(String[] args) {
        Task2 task2 = new Task2();
        Logger log = Logger.getLogger(Task2.class.getName());
        log.severe(task2.writeFile());
    }

    public String writeFile () {
        Byte number = 0;
        try (FileWriter fw = new FileWriter("result.txt", false)) { 
            Scanner iScanner = new Scanner(System.in);
            System.out.println("Введите число : ");
            number = iScanner.nextByte();
            fw.write(number.toString());
            fw.flush(); 
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (InputMismatchException valueOf){
            System.out.println("Введите другое значение");
        }
        return number.toString();
        } 
        
}