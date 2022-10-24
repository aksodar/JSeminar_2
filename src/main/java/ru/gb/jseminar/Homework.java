package ru.gb.jseminar;

public class Homework {

    // Дана строка sql-запроса "select * from students".
    // Сформируйте часть WHERE этого запроса, используя StringBuilder.
    //
    // 1) Данные для фильтрации подаются в метод двумя массивами paramName и paramValue.
    // 2) Данные для фильтрации подаются в метод строкой в формате json.
    public static void main(String[] args) {
        Homework hw = new Homework();

        String request = "SELECT * FROM students";
        String[] name = {"Ivan", "Petr", "Nikita"};
        String[] value = {"Ivanov", "Petrov", "Osipov"};
        String jsonString = "{\"Ivan\": \"Ivanov\", \"Petr\": \"Petrov\", \"Nikita\": \"Osipov\"}";

        System.out.println("1) Данные для фильтрации подаются в метод двумя массивами paramName и paramValue: ");
        System.out.println(hw.updateQueryByArrays(request, name, value));
        System.out.println("\n2) Данные для фильтрации подаются в метод строкой в формате json: ");
        System.out.println(hw.updateQueryByJson(request, jsonString));
    }

    public String updateQueryByArrays(String q, String[] paramName, String[] paramValue){
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
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(e);
                return null;
            }
        }
    }

    public String updateQueryByJson(String q, String js){
        if (js.length() == 0){
            return q;
        } else {
            StringBuilder sb = new StringBuilder(q);
            sb.append(" WHERE ");
            js = js.substring(1, js.length() - 1);
            String[] jsonStr = js.split(", ");
            for (int i = 0; i < jsonStr.length; i++) {
                jsonStr[i] = jsonStr[i].substring(1, jsonStr[i].length() - 1);
                jsonStr[i] = jsonStr[i].replace("\": \"", "=");
                sb.append(jsonStr[i]);
                if (i < jsonStr.length - 1){
                    sb.append(" AND ");
                }
            }
            return sb.toString();
        }
    }
}
