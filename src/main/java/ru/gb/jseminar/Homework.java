package ru.gb.jseminar;

import java.util.Arrays;
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

//        String[] paramName = {"firstName", "secondName", "thirdName"};
//        String[] paramValue = {"Ivan", "Ivanov", "Ivanovich"};
//        String updateQuery = hw.updateQueryByArrays(q, paramName, paramValue);

        String json = "{'firstName': 'Ivan', 'secondName': 'Ivanov', 'thirdName': 'Ivanovich'}";
        String updateQuery = hw.updateQueryByJson(q, json);

        Logger log = Logger.getLogger(Homework.class.getName());
        log.info(updateQuery);
    }

    public String updateQueryByArrays(String q, String[] paramName, String[] paramValue){
        StringBuilder sbq = new StringBuilder(q);
        sbq.append(" where");
        for (int i = 0; i < paramName.length; i++){
            sbq.append(" " + paramName[i] + " = " + paramValue[i]);
            if (i != paramName.length - 1){
                sbq.append(" and");
            }
        }
        return sbq.toString();
    }

    public String updateQueryByJson(String q, String json){
        StringBuilder sbq = new StringBuilder(q);
        sbq.append(" where ");
        sbq.append(json.substring(2, json.length() - 2).replace("': '", " = ").replace("', '", " and "));
        return sbq.toString();
    }
}
