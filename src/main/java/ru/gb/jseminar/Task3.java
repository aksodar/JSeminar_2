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
        Task3 t3 = new Task3();
        String fileUrl = "https://raw.githubusercontent.com/aksodar/JSeminar_2/master/src/main/resources/example.txt";
        String fileContent = t3.download(fileUrl);
        fileContent = t3.change("userName",fileContent);
        t3.saveOnLocal("fileName.txt", fileContent);
        t3.read("fileName.txt");
    }

    public String download(String urlText) {
        try (BufferedInputStream bf = new BufferedInputStream(new URL(urlText).openStream())) {
            return new String(bf.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String change(String name, String fileContent) {

        return String.format(fileContent, name);
    }

    public void read(String localFilename) {
        try {
            Logger log = Logger.getLogger(Task3.class.getName());
            FileReader fr = new FileReader(localFilename);
            BufferedReader br = new BufferedReader(fr);
            while (br.readLine() != null){
                log.info(br.readLine());
            }
            fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveOnLocal(String fileName, String fileContent) {
        try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(fileContent);
            bw.flush();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean removeFromLocale(String fileName) {

        return false;
    }
}
