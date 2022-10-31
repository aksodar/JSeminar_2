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
        String fileUrl = "https://raw.githubusercontent.com/aksodar/JSeminar_2/master/src/main/resources/example.txt";
        String name = "Forty Threepigs";
        String localFilePath = "./file.txt";

        Task3 t = new Task3();
        String fileContent = t.download(fileUrl);
        String fixedFileContent = t.change(name, fileContent);
        t.saveOnLocal(localFilePath,fixedFileContent);
        t.read(localFilePath);
        t.removeFromLocale(localFilePath);
    }

    public String download(String url) {
        try (
                BufferedInputStream bs = new BufferedInputStream(new URL(url).openStream());
        ) {
            String res = new String(bs.readAllBytes());
            return res;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String change(String name, String fileContent) {
        return String.format(fileContent, name);
    }
    public void saveOnLocal(String fileName, String fileContent) {
        try (
                FileWriter fw = new FileWriter(fileName);
                BufferedWriter bw = new BufferedWriter(fw);
                ) {
            bw.write(fileContent);
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void read(String localFilename){
        try (
                FileReader fr = new FileReader(localFilename);
                BufferedReader br = new BufferedReader(fr);
                ) {
            Logger log = Logger.getLogger(Task3.class.getName());
            String line;
            while ((line = br.readLine()) != null){
                log.info(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean removeFromLocale(String fileName) {
        try
        {
            File f = new File(fileName);
            f.delete();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
