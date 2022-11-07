package ru.gb.jseminar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
        String q = "select * from student where ";
        String[] paramName = {"firstName", "secondName", "phoneNumber", "position"};
        String[] paramValue = {"Ivan","Ivanov", "987654", "manager"};
        System.out.printf(hw.updateQueryByArrays(q,paramName,paramValue));



    }

    public String updateQueryByArrays(String q, String[] paramName, String[] paramValue){
        StringBuilder result = new StringBuilder(q);
//        ArrayList<String> finalString = new ArrayList<>();
        for (int i = 0; i< paramValue.length; i++ ) {
            result.append(paramName[i]);
            result.append(" ");
            result.append(" = ");
            result.append(" ");
            result.append(paramValue[i] );
            if (i < paramValue.length - 1) result.append(", ");
            else result.append(".");


        }
        String finalString = result.toString();
        return finalString;
    }

    public String updateQueryByJson(String q, String json){


        return "";
    }
}
