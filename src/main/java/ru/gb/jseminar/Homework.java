package ru.gb.jseminar;

import java.util.logging.Logger;

public class Homework {

    // Дана строка sql-запроса "select * from students".
    // Сформируйте часть WHERE этого запроса, используя StringBuilder.
    //
    // 1) Данные для фильтрации подаются в метод двумя массивами paramName и paramValue.
    // 2) Данные для фильтрации подаются в метод строкой в формате json.
    //      Пример json: {"firstName": "Ivan", "secondName": "Ivanov", ....}
    // Результат работы методов: "select * from students where firstName = 'Ivan' and ...".
    public static void main(String[] args) {
        String q = "select * from students";
        String[] paramName = {"firstName", "secondName", "city"};
        String[] paramValue = {"Ivan", "Ivanov", "Kazan"};
        String json = "{\"firstName\": \"Ivan\", \"secondName\": \"Ivanov\", \"city\": \"Kazan\"}";

        Logger log = Logger.getLogger(Homework.class.getName());
        log.info(Homework.updateQueryByArrays(q, paramName, paramValue));
        log.info(Homework.updateQueryByJson(q, json));

    }

    public static String updateQueryByArrays(String q, String[] paramName, String[] paramValue){
        StringBuilder sb = new StringBuilder();
        sb.append(q).append(" where ");
        for (int i = 0; i < paramName.length; i++) {
            sb.append(paramName[i]).append(" = '").append(paramValue[i]).append("'");
            if (i != paramName.length - 1) sb.append(" and ");
        }
        return sb.toString();
    }

    public static String updateQueryByJson(String q, String json){
        String[] jsonArray;
        String[] jsonArrayInArray;
        StringBuilder sb = new StringBuilder(json);
        sb.delete(0,1);
        sb.setLength(sb.length() - 1);
        json = sb.toString();
        sb = new StringBuilder(q);
        sb.append(" where ");
        jsonArray = json.split(",");
        for (int i = 0; i < jsonArray.length; i++) {
            jsonArrayInArray = jsonArray[i].split(":");
            sb.append(jsonArrayInArray[0].replace("\"", "").replace(" ", ""));
            sb.append(" = ").append(jsonArrayInArray[1].replace("\"", "'").replace(" ", ""));
            if (i != jsonArray.length - 1) sb.append(" and ");
            //sb.append(paramName[i]).append(" = '").append(paramValue[i]).append("'");
        }
        return sb.toString();
    }
}
