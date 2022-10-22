package ru.gb.jseminar;

import java.io.IOException;

public class Homework {

    // Дана строка sql-запроса "select * from students".
    // Сформируйте часть WHERE этого запроса, используя StringBuilder.
    //
    // 1) Данные для фильтрации подаются в метод двумя массивами paramName и paramValue.
    // 2) Данные для фильтрации подаются в метод строкой в формате json.
    public static void main(String[] args) {
        String sqlRequest = "select * from students";
        Homework HW2 = new Homework();
        String[] str2 = {"1", "2"};
        String[] str1 = {"2", "1"};
//        String[] str2 = {"0"};
//        String[] str2 = {};
        System.out.println(HW2.updateQueryByArrays(sqlRequest, str1, str2));
    }

    public String updateQueryByArrays(String q, String[] paramName, String[] paramValue) {
        if (paramName.length == 0 || paramValue.length == 0) {
            return q;
        } else {
            try {
                if (paramName.length != paramValue.length){
                    throw new ArrayIndexOutOfBoundsException();
                }
                StringBuilder sb = new StringBuilder(q);
                sb.append(" WHERE ");
                for (int i = 0; i < paramName.length; i++) {
                    sb.append(paramName[i]);
                    sb.append("=");
                    sb.append(paramValue[i]);
                    if (i != paramName.length - 1) {
                        sb.append(" AND ");
                    }
                }
                return sb.toString();
            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println(exception);
                return null;
            }
        }
    }

    public String updateQueryByJson(String q, String[] paramName, String[] paramValue){

        return "";
    }
}
