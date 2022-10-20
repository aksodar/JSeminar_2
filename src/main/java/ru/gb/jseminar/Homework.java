package ru.gb.jseminar;
import java.util.logging.Logger;
public class Homework {

    // Дана строка sql-запроса "select * from students".
    // Сформируйте часть WHERE этого запроса, используя StringBuilder.
    //
    // 1) Данные для фильтрации подаются в метод двумя массивами paramName и paramValue.
    // 2) Данные для фильтрации подаются в метод строкой в формате json.
    public static void main(String[] args) {
        String [] paramName = {"Name", "surName", "age", "city"};
        String [] paramValue = {"Enrik", "Hak", "29", "Pinsk"};
        String gq = "SELECT * FROM students WHERE ";
        Homework hw = new Homework();
        Logger log = Logger.getLogger(Homework.class.getName());
        String getQuery = hw.updateQueryByArrays(gq, paramName, paramValue);
        log.info(getQuery);
        String json = "{'Name' : 'Enrik', 'surName' : 'Hak', 'age' : '29', 'city' : 'Pinsk'}";
        getQuery = hw.updateQueryByJson(gq, json);
        log.info(getQuery);
    }

    public String updateQueryByArrays(String gq, String[] paramName, String[] paramValue) {
        StringBuilder getQuery = new StringBuilder();
        getQuery.append(gq);
        for (int i = 0; i < paramName.length; i++) {          
            getQuery.append(paramName[i]);
            getQuery.append(" = ");
            getQuery.append(paramValue[i]);
            if (i < paramName.length - 1) {
                getQuery.append(" AND ");
            }
        }
        return getQuery.toString();
    }

    public String updateQueryByJson(String gq, String json) {
        StringBuilder getQuery = new StringBuilder();
        getQuery.append(gq);
        String [] jsnTwin = json.substring(1, json.length()-1).split(", ");
        String [] wordsJsn = new String [2];
        for (int i = 0; i < jsnTwin.length; i++) {
            wordsJsn = jsnTwin[i].split(" : ");
            getQuery.append(wordsJsn[0].replace("'", ""));
            getQuery.append(" = ");
            getQuery.append(wordsJsn[1].replace("'", ""));   
            if (i < jsnTwin.length - 1) {
                getQuery.append(" AND ");
            }      
        }
        return getQuery.toString();
    }
}
