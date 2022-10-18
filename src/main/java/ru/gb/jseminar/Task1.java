package ru.gb.jseminar;

import java.util.logging.Logger;

public class Task1 {

	// Вам дается строка S и целочисленный массив индексов int index[s.length].
	// Напишите программу, которая перетасует символы в S таким образом,
	// что символ c i-й позиции переместится на индекс index[i] в результирующей строке.
	//
	// Пример: s = “cba”, index = [3,2,1] result “abc”
	public static void main(String[] args) {
		System.out.print("\033[H\033[2J");	// Очистка консоли (работает в Windows, на остальных системах не проверял)
		System.out.flush();

		String str = "cba";
		int[] indexArr = new int[] {3, 2, 1};

		Task1 task1 = new Task1();

		Logger log = Logger.getLogger(Task1.class.getName());
		log.info(task1.shuffle(str, indexArr));
	}

	public String shuffle(final String s, final int[] index) {
		if (s.length() == index.length) {
			String[] result = new String[index.length];
			for (int i = 0; i < index.length; i ++) {
				result[index[i] - 1] = String.valueOf(s.charAt(i));
			}
			return String.join("", result);
		} else {
			Logger log = Logger.getLogger(Task1.class.getName());
			log.warning("ОШИБКА! Не корректные входные данные!");
			return "";
		}
	}

}
