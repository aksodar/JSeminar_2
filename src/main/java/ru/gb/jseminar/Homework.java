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
        Homework hw = new Homework();
        String q = "SELECT * FROM students ";
        String json = "{\"firstName\": \"Ivan\", \"secondName\": \"Ivanov\", \"age\": \"24\"}";
        String [] paramName = new String[] {"firstName", "age"};
        String [] paramValue = new String[] {"Ivan", "24"};
        System.out.println(hw.updateQueryByArrays(q, paramName, paramValue));
        System.out.println(hw.updateQueryByJson(q, json));
    }

    public String updateQueryByArrays(String q, String[] paramName, String[] paramValue) {
        String w = "WHERE ";
        StringBuilder sb = new StringBuilder(q);
            if (paramName.length == 0 && paramValue.length == 0) {
                return q;
            }
            else if (paramName.length != paramValue.length) {
                throw new IllegalStateException("Exception");
            }
            else {
                sb.append(w);
                for (int i = 0; i < paramName.length; i++) {
                    sb.append(paramName[i])
                    .append(" = ")
                    .append("\"" + paramValue[i] + "\"");
                    if (i != paramName.length - 1) {
                        sb.append(" AND ");
                    }
                }
            }
        return sb.toString();
    }
    public String updateQueryByJson(String q, String json){
        String w = "WHERE ";
        StringBuilder sbd = new StringBuilder(json);
        sbd.delete(0, 1);
        sbd.delete((json.length() - 2), (json.length() - 1));
        String[] arrStrings = sbd.toString().split(", ");
        StringBuilder sb = new StringBuilder(q);
        sb.append(w);
        if (sbd.length() == 0) {
            return q;
        }
        else {
            for (int i = 0; i < arrStrings.length; i++) {
                sb.append(arrStrings[i].split(": ")[0]
                        + " = "
                        + (arrStrings[i].split(": ")[1]));
                if (i != arrStrings.length - 1) {
                    sb.append(" AND ");
                }
            }
        }

        return sb.toString();
    }
}
