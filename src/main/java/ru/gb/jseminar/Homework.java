package ru.gb.jseminar;

import java.util.Scanner;
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
        String[] paramName = {"firsName", "secondName", "age", "city", "id"};
        String[] paramValue = {"Dmitry", "Pyanzin", "34", "Novomoscowsk", "1"};
        String json = "{'firsName':'Dmitry', 'secondName':'Pyanzin', 'age':'34', 'city':'Novomoscowsk', 'id':'1'}";
        String q = "select * from students ";
        Logger log = Logger.getLogger(Homework.class.getName());
        log.info("Для фильтрации SQL введите 1, для json введите 2: ");
        Scanner sc = new Scanner(System.in);
        int answer = sc.nextInt();
        sc.close();

        if (answer == 1) {
            hw.updateQueryByArrays(q, paramName, paramValue);
        } else if (answer == 2){
            hw.updateQueryByJson(q, json);
        } else {
            log.warning("Нужно вводить 1 или 2");
        }
    }

    public void updateQueryByArrays(String q, String[] paramName, String[] paramValue){
        StringBuilder sb = new StringBuilder();
        Logger log = Logger.getLogger(Homework.class.getName());
        for (int i = 0; i < paramName.length; i++) {
            log.info(sb.append(q).append(paramName[i]).append(" = ").append(paramValue[i]).toString());
            sb.delete(0, sb.length() - 1);
        }
    }

    public void updateQueryByJson(String q, String json){
        StringBuilder sb = new StringBuilder();
        Logger log = Logger.getLogger(Homework.class.getName());
        json = json.substring(1, json.length() - 1);
        String[] jsn = json.split(", ");
        String[] jsnParse;

        for (String s : jsn) {
            jsnParse = s.split(":");
            log.info(sb.append(q).append(jsnParse[0]).append(" = ").append(jsnParse[1]).toString());
            sb.delete(0, sb.length() - 1);
        }
    }
}
