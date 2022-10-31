package ru.gb.jseminar;

public class Homework {

    // Дана строка sql-запроса "select * from students".
    // Сформируйте часть WHERE этого запроса, используя StringBuilder.
    //
    // 1) Данные для фильтрации подаются в метод двумя массивами paramName и paramValue.
    // 2) Данные для фильтрации подаются в метод строкой в формате json.
    //      Пример json: {"firstName": "Ivan", "secondName": "Ivanov", ....}
    // Результат работы методов: "select * from students where firstName = 'Ivan' and ...".
    public static void main(String[] args) {
        String query = "select * from students";
        String[] paramName = new String[]{"firstname", "lastname"};
        String[] paramValue = new String[]{"Ivan", "Ivanov"};
        String json = "{\"firstName\": \"Ivan\", \"secondName\": \"Ivanov\"}";

        query += " where ";

        Homework hw = new Homework();
        System.out.println(hw.updateQueryByArrays(query, paramName, paramValue));
        System.out.println(hw.updateQueryByJson(query,json));
    }

    public String updateQueryByArrays(String q, String[] paramName, String[] paramValue){
        for (int i = 0; i < paramName.length-1; i++) {
            q += paramName[i] + " = '" + paramValue[i] + "' and ";
        }
        q += paramName[paramName.length-1] + " = '" + paramValue[paramValue.length-1] + "'";
        return q;
    }

    public String updateQueryByJson(String q, String json){
        json = json.substring(1,json.length()-1);
        //System.out.println(json);
        String[] pairs = json.split(",");
        String[] paramName = new String[pairs.length];
        String[] valueName = new String[pairs.length];
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = pairs[i].strip().replaceAll("\"", "");
            paramName[i] = pairs[i].split(":")[0];
            valueName[i] = pairs[i].split(":")[1].strip();
        }
        Homework hw = new Homework();
        return hw.updateQueryByArrays(q,paramName,valueName);

    }
}
