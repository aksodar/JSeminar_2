package ru.gb.jseminar;

import java.util.logging.Logger;

public class Homework {

	// Дана строка sql-запроса "select * from students".
	// Сформируйте часть WHERE этого запроса, используя StringBuilder.
	//
	// 1) Данные для фильтрации подаются в метод двумя массивами paramName и paramValue.
	// 2) Данные для фильтрации подаются в метод строкой в формате json.
	public static void main(String[] args) {
		System.out.print("\033[H\033[2J");	// Очистка консоли (работает в Windows, на остальных системах не проверял)
		System.out.flush();

		String sqlRequest = "select * from students";
		String[] name = new String[] {"firstName", "secondName", "age"};
		String[] value = new String[] {"Ivan", "Petrov", "21"};
		String jsonString = "{\"firstName\":\"Ivan\", \"secondName\":\"Petrov\", \"age\":\"21\"}";

		Homework hw = new Homework();

		Logger log = Logger.getLogger(Homework.class.getName());
		log.info(hw.updateQueryByArrays(sqlRequest, name, value));
		log.info(hw.updateQueryByJson(sqlRequest, jsonString));
	}

	public String updateQueryByArrays(String q, String[] paramName, String[] paramValue) {
		StringBuilder result = new StringBuilder();
		result.append(q + " WHERE ");
		if (paramName.length == paramValue.length && paramName.length > 0) {
			for (int i = 0; i < paramName.length; i ++) {
				result.append(paramName[i] + "=" + paramValue[i] + " AND ");
			}
			return String.valueOf(result.substring(0, result.length() - 5));
		} else {
			Logger log = Logger.getLogger(Homework.class.getName());
			log.warning("ОШИБКА! Не правильный формат входных данных");
			return "";
		}
	}

	public String updateQueryByJson(String q, String json) {
		Homework hw = new Homework();
	
		json = json.replace("{", "");
		json = json.replace("}", "");
		if (json.contains(":")) {
			String[] jsonArr = json.split(", ");
			String[] paramName = new String[jsonArr.length];
			String[] paramValue = new String[jsonArr.length];

			for (int i = 0; i < jsonArr.length; i ++) {
				if (jsonArr[i].split(":").length > 1) {
					paramName[i] = jsonArr[i].split(":")[0];
					paramName[i] = paramName[i].replace("\"", "");
					paramValue[i] = jsonArr[i].split(":")[1];
					paramValue[i] = paramValue[i].replace("\"", "");
				} else {
					Logger log = Logger.getLogger(Homework.class.getName());
					log.warning("ОШИБКА! Не правильный формат входных данных");
					return "";
				}
			}
			return hw.updateQueryByArrays(q, paramName, paramValue);
		} else {
			Logger log = Logger.getLogger(Homework.class.getName());
			log.warning("ОШИБКА! Не правильный формат входных данных");
			return "";
		}
	}
}
