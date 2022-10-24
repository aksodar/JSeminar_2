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
        Logger log = Logger.getLogger(Homework.class.getName());
        String sqlSTR = "SELECT * FROM Students";
        String[] paramName = new String [] {"firstName", "secondName", "value"};
        String[] paramValue = new String [] {"Aleksandr", "Aleksandrov", "sales"};
        String js = "{\"firstName\": \"Alex\", \"secondName\": \"Rakhmanin\", \"value\": \"database\"}";
        log.info(hw.updateQueryByArrays(sqlSTR, paramName, paramValue));
        log.info(hw.updateQueryByJson(sqlSTR, js));   
    }

    public String updateQueryByArrays(String q, String[] paramName, String[] paramValue){
        StringBuilder sb = new StringBuilder();
        sb.append(q).append(" WHERE ");
        for(int i = 0; i < paramName.length; i++) {
            sb.append(paramName[i] + " = '" + paramValue[i] + "'");
            if(paramName.length != i + 1) {
                sb.append(" AND ");
            }
            if(paramName.length == i + 1) {
                sb.append(";");
            }
        }
        return sb.toString();
    }

    public String updateQueryByJson(String q, String json){
        StringBuilder sb = new StringBuilder();
        json = json.substring(1, json.length() - 1).replace(":", "").replace(",", "");
        String[] arrJS = json.split(" ");
        sb.append(q).append(" WHERE ");
        for(int i = 0; i < arrJS.length; i++) {
            if(i%2 == 0) {
                arrJS[i] = arrJS[i].substring(1, arrJS[i].length() - 1);
                sb.append(arrJS[i]);
                sb.append(" = ");
            }
            if(i%2 == 1 && i != arrJS.length - 1) {
                arrJS[i] = arrJS[i].replace("\"", "'");
                sb.append(arrJS[i]);
                sb.append(" AND ");
            }
            if(i == arrJS.length - 1) {
                arrJS[i] = arrJS[i].replace("\"", "'");
                sb.append(arrJS[i]);
                sb.append(";");
            }
        }
        return sb.toString();
    }
}
