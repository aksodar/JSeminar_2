package ru.gb.jseminar;

import java.io.IOException;
import java.util.logging.Logger;

public class Homework {

    // Дана строка sql-запроса "select * from students".
    // Сформируйте часть WHERE этого запроса, используя StringBuilder.
    //
    // 1) Данные для фильтрации подаются в метод двумя массивами paramName и
    // paramValue.
    // 2) Данные для фильтрации подаются в метод строкой в формате json.
    public static void main(String[] args) {
        Homework hw = new Homework();
        String text = "select * from students";
        String[] paramName = new String[] { "firstName", "secondName", "lastName",
                "gender" };
        // String[] paramName = new String[0];
        String[] paramValue = new String[] { "John", "Sergeevich", "West", "male" };
        String strJson = "{\"firstName\": 'John', \"secondName\": 'Sergeevich', \"lastName\": 'West', \"gender\": 'male'}";
        // String strJson = "";

        Logger log = Logger.getLogger(Homework.class.getName());
        log.info(hw.updateQueryByArrays(text, paramName, paramValue));
        log.info(hw.updateQueryByJson(text, strJson));

    }

    public String updateQueryByArrays(String q, String[] paramName, String[] paramValue) {
        StringBuilder str = new StringBuilder(q);
        str.append(" WHERE ");
        if (paramName.length == 0 || paramValue.length == 0) {
            throw new IllegalArgumentException("Один из массивов пустой!");
        } else {
            int size = 0;
            if (paramName.length > paramValue.length) {
                size = paramValue.length;
            } else {
                size = paramName.length;
            }
            for (int i = 0; i < size; i++) {
                str.append(paramName[i]);
                str.append(" = ");
                str.append("'" + paramValue[i] + "'");
                if (i != size - 1) {
                    str.append(" AND ");
                }
            }
            return str.toString();
        }
    }

    public String updateQueryByJson(String q, String json) {
        StringBuilder str = new StringBuilder(q);
        if (json.length() != 0) {
            str.append(" WHERE ");
            json = json.substring(1, json.length() - 1);
            String[] arrJson = json.split(", ");
            for (int i = 0; i < arrJson.length; i++) {
                arrJson[i] = arrJson[i].replace("\"", "");
                arrJson[i] = arrJson[i].replace(":", " =");
                str.append(arrJson[i]);
                if (i < arrJson.length - 1) {
                    str.append(" AND ");
                }
            }

        } else {
            return q;
        }

        return str.toString();
    }
}
