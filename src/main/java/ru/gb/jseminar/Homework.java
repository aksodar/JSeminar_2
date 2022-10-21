package ru.gb.jseminar;

import java.util.logging.Logger;

public class Homework {

    // Дана строка sql-запроса "select * from students".
    // Сформируйте часть WHERE этого запроса, используя StringBuilder.
    //
    // 1) Данные для фильтрации подаются в метод двумя массивами paramName и paramValue.
    // 2) Данные для фильтрации подаются в метод строкой в формате json.
    public static void main(String[] args) {
        String[] paraName = {};
        String[] paraValue = {};

        String q = "select * from students WHERE";

        String json = { };

        Homework hw = new Homework();
        Logger log = Logger.getLogger(Homework.class.getName());
        hw.updateQueryByArrays(q, paraName, paraValue);
        hw.updateQueryByJson(q, json);

    }

    public String updateQueryByArrays(String q, String[] paramName, String[] paramValue) {
        StringBuilder sb = new StringBuilder();
        Logger log = Logger.getLogger(Homework.class.getName());

        for (int i = 0; i < paramName.length; i++) {
            sb.append(q);
            sb.append(paramName[i]);
            sb.append(" = ");
            sb.append(paramValue[i]);
            log.info(sb.toString());
            sb.delete(0, sb.length());
        }
        return "";
    }

    public String updateQueryByJson(String q, String json) {
        String j = json.substring(1, json.length() - 1);
        StringBuilder sb = new StringBuilder();
        Logger log = Logger.getLogger(Homework.class.getName());

        String[] pair_dict = j.split(",");
        for (int i = 0; i < pair_dict.length; i++) {

            String[] data = pair_dict[i].split(":");

            for (int k = 0; k < data.length - 1; k++) {
                sb.append(q);
                sb.append(data[k]);
                sb.append(" = ");
                sb.append(data[k + 1]);
                log.info(sb.toString());
                sb.delete(0, sb.length());
            }
        }
        return "";
    }
}

































