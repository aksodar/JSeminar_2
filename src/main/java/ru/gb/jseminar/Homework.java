package ru.gb.jseminar;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

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
        String q = "select * from students";
        String [] paramName = new String []{"firstName", "secondName"};
        String [] paramValue = new String []{"\"Ivan\"", "\"Ivanov\""};
        String json = "{\"firstName\": \"Ivan\", \"secondName\": \"Ivanov\"}";
        
        System.out.println(hw.updateQueryByArrays(q, paramName, paramValue)); 
        System.out.println(hw.updateQueryByJson(q, json)); 
    }

    public String updateQueryByArrays(String q, String[] paramName, String[] paramValue){
        StringBuilder sb = new StringBuilder();
        if (paramName.length == 0 && paramValue.length == 0)
        {
            sb.append(q);
            sb.append(" where");
        }
        else if (paramName.length != paramValue.length)
        {
            throw new IllegalStateException("Массивы содержат разное количество элементов. Запрос не может быть выполнен.");
        }
        else
        {
            sb.append(q);
            sb.append(" where");
            for (int i = 0; i < paramName.length; i++)
            {
                sb.append(" " + paramName[i] + " = " + paramValue[i]);
                if (i < (paramName.length - 1)) sb.append(" and");
            }
        }
        return sb.toString();
    }

    public String updateQueryByJson(String q, String json){
        json = json.substring(1, (json.length() - 1));
        String[] subStr;
        String[] subStr2;
        String delimeter = ","; 
        subStr = json.split(delimeter); 
                
        String delimeter2 = ":"; 
        String [] paramName1 = new String [subStr.length];
        String [] paramValue1 = new String [subStr.length];

        for (int i = 0; i < subStr.length; i++)
        {
            subStr2 = subStr[i].split(delimeter2);
            paramName1[i] = subStr2[0].replaceAll("[\" ]", "");
            paramValue1[i] = subStr2[1].trim();
        }

        return updateQueryByArrays(q, paramName1, paramValue1);
    }
}