package ru.gb.jseminar;

import java.util.logging.Logger;

public class Homework {

    // Дана строка sql-запроса "select * from students".
    // Сформируйте часть WHERE этого запроса, используя StringBuilder.
    //
    // 1) Данные для фильтрации подаются в метод двумя массивами paramName и
    // paramValue.
    // 2) Данные для фильтрации подаются в метод строкой в формате json.
    // Пример json: {"firstName": "Ivan", "secondName": "Ivanov", ....}
    // Результат работы методов: "select * from students where firstName = 'Ivan'
    // and ...".
    public static void main(String[] args) {
        Homework hw = new Homework();
        Logger log = Logger.getLogger(Homework.class.getName());
        String sql = "select * from students";
        String[] paramName = { "firstName", "secondName", "value" };
        String[] paramValue = { "Ivan", "Ivanov", "age" };
        String json = "{\"firstName\": \"Ivan\", \"secondName\": \"Ivanov\", \"value\": \"level\"}";
        log.info(hw.updateQueryByArrays(sql, paramName, paramValue));
        log.info(hw.updateQueryByJson(sql, json));
    }

    public String updateQueryByArrays(String q, String[] paramName, String[] paramValue) {
        StringBuilder sb = new StringBuilder();
        sb.append(q).append(" where ");
        for (int i = 0; i < paramName.length; i++) {
            sb.append(paramName[i] + " = '" + paramValue[i] + "'");
            if (paramName.length != i + 1) {
                sb.append(" and ");
            }
        }
        return sb.toString();
    }

    public String updateQueryByJson(String q, String json) {
        StringBuilder sb = new StringBuilder();
        json = json.substring(1, json.length() - 1).replace(":", "").replace(",", "");
        String[] array = json.split(" ");
        sb.append(q).append(" where ");
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0) {
                array[i] = array[i].substring(1, array[i].length() - 1);
                sb.append(array[i]);
                sb.append(" = ");
            }
            if (i % 2 == 1 && i != array.length - 1) {
                array[i] = array[i].replace("\"", "'");
                sb.append(array[i]);
                sb.append(" and ");
            }
            if (i == array.length - 1) {
                array[i] = array[i].replace("\"", "'");
                sb.append(array[i]);
            }
        }
        return sb.toString();
    }
}
