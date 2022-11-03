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
        Homework hw = new Homework();
        String q = "select * from students";

        String[] paramName = new String[]{"firstName", "secondName", "Address"};
        String[] paramValue = new String[]{"Ivan", "Ivanov", "Moscow"};
        String queryByArrays = hw.updateQueryByArrays(q, paramName, paramValue);
        Logger logger1 = Logger.getLogger(Homework.class.getName());
        logger1.info(queryByArrays);


        String json = "{'firstName': 'Ivan', 'secondName': 'Ivanov', 'Address': 'Moscow'}";
        String queryByJson = hw.updateQueryByJson(q, json);
        Logger logger2 = Logger.getLogger(Homework.class.getName());
        logger2.info(queryByJson);

    }

    public String updateQueryByArrays(String q, String[] paramName, String[] paramValue) {
        StringBuilder sb = new StringBuilder(q);
        sb.append(" WHERE ");
        for (int i = 0; i < paramName.length; i++) {
            sb.append(paramName[i]);
            sb.append(" = ");
            sb.append(paramValue[i]);
            if (i != paramName.length - 1) {
                sb.append(" and ");
            }

        }
        return sb.toString();
    }

    public String updateQueryByJson(String q, String json) {
        StringBuilder sb = new StringBuilder(q);
        sb.append(" WHERE ");
        json= json.substring(2,json.length()-2);
        json=json.replace("': '", " = ").replace("', '", " and ");
        sb.append(json);

        return sb.toString();
    }
}
