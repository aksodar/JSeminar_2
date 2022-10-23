package ru.gb.jseminar;

import java.util.Objects;
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
        Homework hw = new Homework();
        Logger log = Logger.getLogger(Homework.class.getName());
        String q = "select * from students";
        String json = "{\"firstName\": \"Ivan\", \"secondName\": \"Ivanov\", \"age\": \"null\"}";
        String[] paramName = new String[]{"firstName", "secondName", "age"};
        String[] paramValue = new String[]{"Ivan", "Ivanov", "null"};
        log.info(hw.updateQueryByArrays(q, paramName, paramValue));
        log.info(hw.updateQueryByJson(q, json));
    }

    public String updateQueryByArrays(String q, String[] paramName, String[] paramValue) {
        StringBuilder sb = new StringBuilder(q);
        sb.append(" WHERE");
        for (int i = 0; i < paramName.length; i++) {
            if (!Objects.equals(paramName[i], "null") && !Objects.equals(paramValue[i], "null")) {
                sb.append(" ").append(paramName[i]).append(" = ").append("'").append(paramValue[i]).append("'");
                if (i != paramName.length - 1) {
                    sb.append(" AND");
                }
            }
        }
        if (sb.toString().endsWith(" AND")) {
            sb.delete(sb.length() - 4, sb.length());
        }
        return sb.toString();

    }

    public String updateQueryByJson(String q, String json) {

        StringBuilder sbj = new StringBuilder(json);
        StringBuilder sbq = new StringBuilder(q);
        sbj.delete(0, 1);
        sbj.delete(sbj.length() - 1, sbj.length());
        sbq.append(" WHERE ");
        json = sbj.toString();
        String[] jsonArray = json.split(", ");
        for (int i = 0; i < jsonArray.length; i++) {
            if (jsonArray[i].contains("null")) {
                jsonArray[i] = "null";
            }
            jsonArray[i] = jsonArray[i].replace("\"", "").replace(": ", " = '");
            System.out.println(jsonArray[i]);
        }
        for (int i = 0; i < jsonArray.length; i++) {
            if (Objects.equals(jsonArray[i], "null")) {
                sbq.append(" ");
            } else {
                if (i != jsonArray.length - 1)
                    sbq.append(jsonArray[i]).append("' AND ");
                else sbq.append(jsonArray[i]).append("' ");
            }

        }
        if (sbq.toString().endsWith("AND ") || sbq.toString().endsWith("AND  ")) {
            sbq.delete(sbq.length() - 5, sbq.length());

        }
        return sbq.toString();
    }
}