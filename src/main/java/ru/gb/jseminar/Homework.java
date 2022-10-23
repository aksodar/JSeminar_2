package ru.gb.jseminar;

public class Homework {

    // Дана строка sql-запроса "select * from students".
    // Сформируйте часть WHERE этого запроса, используя StringBuilder.
    //
    // 1) Данные для фильтрации подаются в метод двумя массивами paramName и paramValue.
    // 2) Данные для фильтрации подаются в метод строкой в формате json.
    public static void main(String[] args) {
        updateQueryByArrays();
    }

    public StringBuilder updateQueryByArrays(String q, String[] paramName, String[] paramValue){
        StringBuilder result= new StringBuilder();
        result.append(q);
        if (paramName==null || paramValue==null) {
            return result;
        }
        result.append("WHERE");
        if (paramName.length!=paramValue.length){
            throw new ArrayIndexOutOfBoundsException();
        }else{
            for (int i = 0; i < paramName.length; i++) {
                result.append(paramName[i]);
                result.append("=");
                result.append(paramValue[i]);
                if (i!= paramName.length-1) {
                    result.append("and");
                }
            }
        }
        return result;
    }

    public String updateQueryByJson(String q, String[] paramName, String[] paramValue){

        return "";
    }
}
