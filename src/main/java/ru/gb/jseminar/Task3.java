package ru.gb.jseminar;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class Task3 {

	// Напишите программу, которая
	// 1) по указанной строке URL скачивает файл и возвращает строковое содержимое файла
	// 2) изменяет строковое содержимое файла подставляя по маске "%s" ваше имя
	// 3) сохраняет файл локально
	// 4) читает сохраненный файл и выводит содержимое в логгер
	// 5) удаляет сохраненный файл
	public static void main(String[] args) {
		System.out.print("\033[H\033[2J");	// Очистка консоли (работает в Windows, на остальных системах не проверял)
		System.out.flush();
		String name = "Aleksey";

		Task3 task3 = new Task3();

		String fileUrl = "https://raw.githubusercontent.com/aksodar/JSeminar_2/master/src/main/resources/example.txt";

		System.out.println(task3.download(fileUrl));
		String newString = task3.change(name, task3.download(fileUrl));
		System.out.println(newString);
		task3.saveOnLocal("file.txt", newString);

	}

	public String download(String urlText) {
		try {
			BufferedInputStream bis = new BufferedInputStream(new URL(urlText).openStream());
			String result = new String(bis.readAllBytes());
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
			FileWriter fw = new FileWriter(fileName);
			BufferedWriter bfw = new BufferedWriter(fw);
			bfw.write(fileContent);
			bfw.flush();
			fw.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean removeFromLocale(String fileName) {

		return false;
	}
}
