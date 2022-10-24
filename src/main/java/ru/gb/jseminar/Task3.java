package ru.gb.jseminar;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

public class Task3 {

    // Напишите программу, которая
    // 1) по указанной строке URL скачивает файл и возвращает строковое содержимое файла
    // 2) изменяет строковое содержимое файла подставляя по маске "%s" ваше имя
    // 3) сохраняет файл локально
    // 4) читает сохраненный файл и выводит содержимое в логгер
    // 5) удаляет сохраненный файл
    public static void main(String[] args) {
        Task3 task = new Task3();
        String fileUrl = "https://raw.githubusercontent.com/aksodar/JSeminar_2/master/src/main/resources/example.txt";
        String name = "Pavel";
        Logger log = Logger.getLogger(Task3.class.getName());
        String fileContent  = task.download(fileUrl);
        log.info(task.change(name, fileContent));
        String fileName = "new.txt";
        task.saveOnLocal(fileName, fileContent);
        task.read(fileName);
    }

    public String download(String url) {
        String result = "";
        try (BufferedInputStream buff = new BufferedInputStream(new URL(url).openStream());
        ) {
            result = new String(buff.readAllBytes());
        return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String change(String name, String fileContent) {
        return String.format(fileContent, name);
    }

    public void saveOnLocal(String fileName, String fileContent) {
        try {
            FileWriter w = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(w);
            bw.write(fileContent);
            bw.flush();
            bw.close();
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public void  read (String localFilename){
        try {
            FileReader r = new FileReader(localFilename);
            BufferedReader br = new BufferedReader(r);
            Logger log = Logger.getLogger(Task3.class.getName());

            while (br.ready()){
                log.info(br.readLine());
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean removeFromLocale(String fileName) {

        return false;
    }
}
