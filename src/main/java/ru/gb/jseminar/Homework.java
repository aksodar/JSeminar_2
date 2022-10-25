package ru.gb.jseminar;

import java.util.logging.Logger;

public class Homework {
    // Дана строка sql-запроса "select * from students".
    // Сформируйте часть WHERE этого запроса, используя StringBuilder.
    //
    // 1) Данные для фильтрации подаются в метод двумя массивами paramName и paramValue.
    // 2) Данные для фильтрации подаются в метод строкой в формате json.
    // select * from students WHERE %s=%s, name, value)  name1 = value1 AND name2 = value2;

    //  array1 = ['SalesOrderID', 'OrderQty'] array2 = [71776, 1]
    //  SELECT * FROM SalesLT.SalesOrderDetail WHERE SalesOrderID=71776
    //  SELECT * FROM SalesLT.SalesOrderDetail WHERE OrderQty=1

    public static void main(String[] args) {
        String [] paramName = {"name", "age", "city", "id", "name"};
        String [] paramValue = {"Ivan", "27", "Ivanovo", "1", "Петя"};

        String q = "select * from students WHERE ";
        Homework hw = new Homework();

        //hw.updateQueryByArrays(q, paramName, paramValue);
        String json = "{'name' : 'Ivan', 'age' : '27', 'city' : 'Ivanovo', 'id' : '1', 'name' : 'Петя'}";
        hw.updateQueryByJson(q, json);

    }
    public String updateQueryByArrays(String q, String[] paramName, String[] paramValue){
        StringBuilder sb = new StringBuilder();
        String result = "";

        Logger log = Logger.getLogger(Homework.class.getName());

        for (int i = 0; i < paramName.length; i++){

            sb.append(q);
            sb.append(paramName[i]);
            sb.append(" = ");
            sb.append(paramValue[i]);
            String  s = sb.toString();
            log.info(s);
            sb.delete(0, sb.length());



        }

        return "";

    }
    public String updateQueryByJson(String q, String json){
        String j = json.substring(1, json.length()-1);
        StringBuilder sb = new StringBuilder();
        Logger log = Logger.getLogger(Homework.class.getName());
        String[] jsn = j.split(", ");
        String[] jsn1 = null;


        for (int i = 0; i < jsn.length; i++) {
                jsn1 = jsn[i].split(" : ");
                sb.append(q);
                sb.append(jsn1[0].substring(1,jsn1[0].length()-1));
                sb.append(" = ");
                sb.append(jsn1[1].substring(1,jsn1[1].length()-1));
                log.info(sb.toString());
                sb.delete(0, sb.length());

        }


        return "";
    }

}
