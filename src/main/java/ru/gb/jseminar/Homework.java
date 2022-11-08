package ru.gb.jseminar;

import netscape.javascript.JSObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
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
        String q = "select * from student ";
        String[] paramName = {"firstName", "secondName", "phoneNumber", "position"};
        String[] paramValue = {"Ivan", "Ivanov", "987654", "manager"};
        String json = "{\"firstName\": \"Ivan\", \"secondName\": \"Ivanov\", \"phoneNumber\": \"987654\", \"position\": \"manager\"}";
        Logger log = Logger.getLogger(Homework.class.getName());
        log.info(hw.updateQueryByArrays(q,paramName,paramValue));
        log.info(hw.updateQueryByJson(q,json));

    }

    public String updateQueryByArrays(String q, String[] paramName, String[] paramValue) {
        StringBuilder result = new StringBuilder(q);
        if (paramName.length == 0 || paramValue.length == 0) return result.toString();
        if (paramName.length == paramValue.length){
            result.append("WHERE ");
            for (int i = 0; i < paramValue.length; i++) {
                result.append(paramName[i]);
                result.append(" = ");
                result.append(paramValue[i]);
                if (i < paramValue.length - 1) result.append(" and ");
                else result.append(".");
            }
            return result.toString();
        }
        else return result.toString();
    }

    public String updateQueryByJson(String q, String json) {
        StringBuilder result = new StringBuilder(q);
        result.append("WHERE ");
        String jsonSub = json.substring(1, json.length() - 1);
        String[] jsonSplit = jsonSub.split(", ");
        for (String words : jsonSplit) {
            String[] wordsSplit = words.split(": ");
            for (int i = 0; i < wordsSplit.length; i++) {
                if (i == 0) {
                    result.append(wordsSplit[i].toString().substring(1, wordsSplit[i].length()-1));
                    result.append(" = ");
                }
                   if (i == 1) {
                       result.append(wordsSplit[i].toString().substring(1, wordsSplit[i].length()-1));
                       result.append(" and ");
                    }
                    }

            }
            result.delete(result.length()-5,result.length()).append(".");


        return result.toString();
        }
    }
