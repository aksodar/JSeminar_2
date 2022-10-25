package ru.gb.jseminar;

import java.io.*;
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
        String fileContent = task.download(fileUrl);
        fileContent = task.change("Ilia", "%s");
        task.saveOnLocal("example.txt", fileContent);
        task.read("example.txt");
    }

    public String download(String urlText) {
        try (
                BufferedInputStream bf = new BufferedInputStream(new URL(urlText).openStream());) {
            String res = new String(bf.readAllBytes());
            return res;
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public String change(String name, String fileContent) {
        try {
            return String.format(fileContent, name);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public void saveOnLocal(String Filename, String fileContent){
        try {
            FileWriter fw = new FileWriter(Filename);
            BufferedWriter bf = new BufferedWriter(fw);
            bf.write(fileContent);
            bf.flush();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void read(String localFileName) {
        try {
            FileReader rf = new FileReader(localFileName);
            BufferedReader bfr = new BufferedReader(rf);
            Logger log = Logger.getLogger(Task3.class.getName());
            while (bfr.readLine() != null){
                log.info(bfr.readLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean removeFromLocale(String fileName) {

        return false;
    }
}
