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
    public static <Strimg> void main(String[] args) {
        Homework hw = new Homework();
        String sqlS = "select * from students";
        String[] parName = new String [] {"firstName", "secondName", "sity", "foneNumber", "progress"};
        String[] parValue = new String [] {"Ivan", "Ivanov", "Moskow", "+78889993344", "excellent"};
        Logger log = Logger.getLogger(Homework.class.getName());
        log.info(hw.updateQueryByArrays(sqlS, parName, parValue));
        String json = "{'firstName': 'Ivan', 'secondName': 'Ivanov', 'sity': 'Moskow', 'foneNumber': '+78889993344', 'progress': 'excellent'}";
        log.info(hw.updateQueryByJson(sqlS, json));

    }

    public String updateQueryByArrays(String q, String[] paramName, String[] paramValue){
        q = new StringBuilder(q).append(", where : ").toString();
        for (int i = 0; i < paramValue.length-1; i++) {
            q = new StringBuilder(q).append(paramName[i]).append(" = ").append("'"+ paramValue[i] +"'").append(", and ").toString();
        }
        q = new StringBuilder(q).append(paramName[paramName.length -1]).append(" = ").append("'"+paramValue[paramValue.length-1]+"'").toString();
        return q;
    }

    public String updateQueryByJson(String q, String json){
        json = new StringBuilder(json).deleteCharAt(0).toString();
        json = new StringBuilder(json).deleteCharAt(json.length()-1).toString();
        q = new StringBuilder(q).append(", where : ").toString();
        System.out.println();
        String [] arr = json.split(", ");
        for (int i = 0; i < arr.length-1; i++) {
            String [] arr1 = arr[i].split(": ");
            q = new StringBuilder(q).append(arr1[0]).append(" = ").append(arr1[arr1.length -1]).append(", and ").toString();
            }
        String [] arr1 = arr[arr.length-1].split(": ");
        q = new StringBuilder(q).append(arr1[0]).append(" = ").append(arr1[arr1.length -1]).toString();     
            
        


        return q;
    }
}