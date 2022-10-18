package ru.gb.jseminar;

import java.util.logging.Logger;

public class Task0 {

	// Посчитайте сколько драгоценных камней в куче обычных камней
	// Пример:
	// jewels = “aB”, stones = “aaaAbbbB”
	// Результат в консоль ”a3B1”
	public static void main(String[] args) {
		System.out.print("\033[H\033[2J");	// Очистка консоли (работает в Windows, на остальных системах не проверял)
		System.out.flush();

		Task0 task0 = new Task0();

		Logger log = Logger.getLogger(Task0.class.getName());

		log.info(task0.findJewelsInStones("aB","aaaAbbbB"));
	}

	public String findJewelsInStones(String jewels, String stones) {
		String result = "";
		for (char jewel : jewels.toCharArray()) {
			int count = 0;
			for (char stone : stones.toCharArray()) 
				if (jewel == stone)		count ++;
			result += String.valueOf(jewel);
			result += count;
		}
		return result;
	}
}
