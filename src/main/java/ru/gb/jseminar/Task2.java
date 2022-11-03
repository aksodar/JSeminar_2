package ru.gb.jseminar;

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

    public String writeFile(){

        
        return "";
    }

}
