package ru.gb.jseminar;
import java.util.logging.Logger;
import javax.xml.namespace.QName;

public class Homework {

    // Дана строка sql-запроса "select * from students".
    // Сформируйте часть WHERE этого запроса, используя StringBuilder.
    //
    // 1) Данные для фильтрации подаются в метод двумя массивами paramName и paramValue.
    // 2) Данные для фильтрации подаются в метод строкой в формате json.
    public static void main(String[] args) {
        Homework task = new Homework();
        String q = "select from students";
        String[] paramName = {"firstName", "secondName"};
        String[] paramValue = {"Ivan", "Ivanov"};
        String json = "{'firstName' : 'Ivan', 'secondName' : 'Ivanov', 'age' : '25'}";
        Logger log = Logger.getLogger(Homework.class.getName());
        log.info(task.updateQueryByArrays(q, paramName, paramValue));
        log.info(task.updateQueryByJson(q, json));

    }

    public String updateQueryByArrays(String q, String[] paramName, String[] paramValue){
        StringBuilder result = new StringBuilder();
        result.append(q+" ");
        result.append("WHERE"+" ");
        for (int i=0; i<paramName.length; i++){
            result.append(paramName[i]+" - "+paramValue[i]+" ");
            if (i<paramName.length-1){
                result.append("AND ");
            }
        }
        String res= new String(result);
        return res;
    }

    public String updateQueryByJson(String q, String json){
        StringBuilder result = new StringBuilder();
        result.append(q);
        result.append(" WHERE"+" ");
        String [] jsTemp = json.substring(1, json.length()-1).split(", ");
        String [] jsNew;
        for (int i = 0; i < jsTemp.length; i++) {
            jsNew = jsTemp[i].split(" : ");            
            result.append(jsNew[0].replace("'", ""));
            result.append(" - ");
            result.append(jsNew[1].replace("'", ""));
            if (i < jsTemp.length - 1) {
                result.append(" AND ");
            }
        }
        String res = result.toString();
        return res;        
    }
}
