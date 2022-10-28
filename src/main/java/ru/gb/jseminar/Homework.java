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
        try {
            Homework hw = new Homework();
            String request = "select from students";
            String[] paramName = {"firstName", "secondName"};
            String[] paramValue = {"Ivan", "Ivanov"};
            String json = "{'firstName' : 'Ivan', 'secondName' : 'Ivanov', 'age' : '21'}";
            Logger logger = Logger.getLogger(Homework.class.getName());
            logger.info(hw.updateQueryByArrays(request, paramName, paramValue));
            logger.info(hw.updateQueryByJson(request, json));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String updateQueryByArrays(String q, String[] paramName, String[] paramValue){


        StringBuilder res = new StringBuilder();
        res.append(q);
        res.append(" WHERE ");
        for (int i = 0; i < paramName.length; i++) {
            res.append(paramName[i]);
            res.append(" = ");
            res.append(paramValue[i]);
            if (i < paramName.length-1){
                res.append(" and ");
            }
        }
        return res.toString();
    }

    public String updateQueryByJson(String q, String json){


        StringBuilder res = new StringBuilder();
        res.append(q);
        String [] jsPairs = json.substring(1, json.length()-1).split(", ");
        String [] jsNew;
        for (int i = 0; i < jsPairs.length; i++) {
            jsNew = jsPairs[i].split(" : ");
            res.append(jsNew[0].replace("'", ""));
            res.append(" = ");
            res.append(jsNew[1].replace("'", ""));
            if (i < jsPairs.length - 1) {
                res.append(" and ");
            }
        }
        return res.toString();
    }
}