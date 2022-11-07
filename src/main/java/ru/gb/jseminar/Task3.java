package ru.gb.jseminar;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;

public class Task3 {

    // Напишите программу, которая
    // 1) по указанной строке URL скачивает файл и возвращает строковое содержимое
    // файла
    // 2) изменяет строковое содержимое файла подставляя по маске "%s" ваше имя
    // 3) сохраняет файл локально
    // 4) читает сохраненный файл и выводит содержимое в логгер
    // 5) удаляет сохраненный файл
    public static void main(String[] args) {
        Task3 task3 = new Task3();
        Logger log = Logger.getLogger(Task3.class.getName());
        String fileUrl = "https://raw.githubusercontent.com/aksodar/JSeminar_2/master/src/main/resources/example.txt";
        String fileContent = task3.download(fileUrl);
        String name = "Leo";
        String changedFileContent = task3.change(name, fileContent);
        task3.saveOnLocal("example.txt", changedFileContent);
        task3.read("example.txt");
        if (task3.removeFromLocale("example.txt")) {
            log.info("File successfully deleted!");
        } else {
            log.info("File not deleted!");
        }
    }

    public String download(String urlText) {
        try (BufferedInputStream bf = new BufferedInputStream(new URL(urlText).openStream());) {
            String result = new String(bf.readAllBytes());
            return result;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String change(String name, String fileContent) {

        return String.format(fileContent, name);
    }

    public void read(String localFilename) {
        try {
            FileReader fr = new FileReader(localFilename);
            BufferedReader bfr = new BufferedReader(fr);
            Logger log = Logger.getLogger(Task3.class.getName());
            // while (bfr.readLine() != null) {
            // log.info(bfr.readLine());
            // }
            log.info(bfr.readLine());
            bfr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveOnLocal(String fileName, String fileContent) {
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bfw = new BufferedWriter(fw);
            bfw.write(fileContent);
            bfw.flush();
            bfw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean removeFromLocale(String fileName) {
        File file = new File(fileName);
        return file.delete();
    }
}
