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
        Logger log = Logger.getLogger(Homework.class.getName());
        
        hw.updateQueryByArrays(q, paramName, paramValue);
        // System.out.println(res);
    }
    public String updateQueryByArrays(String q, String[] paramName, String[] paramValue){
        StringBuilder sb = new StringBuilder();
        String result [] = new String[paramName.length];
        
        Logger log = Logger.getLogger(Homework.class.getName());
        
        for (int i = 0; i < paramName.length; i++){
            
            sb.append(q);
            sb.append(paramName[i]);
            sb.append(" = ");
            sb.append(paramValue[i]);
            log.info(sb.toString());
            // result[i] = sb.toString();
            sb.delete(0, sb.length());
            
            
            
        }
        
        return "";
        
    }
    public String updateQueryByJson(String q, String json){
        String j = json.substring(1, json.length()-1);
        StringBuilder sb = new StringBuilder();
        Logger log = Logger.getLogger(Homework.class.getName());


        // for (String retval : j.split(",")) {
        //     // System.out.println(retval);
        //     for (String ret : retval.split(":")) {
        //     // System.out.println(ret);
        //         for (int i = 0; i < ret.length()-1; i+=2){
        //             System.out.println(ret.getClass().getSimpleName());
        //             sb.append(q);
        //             // sb.append(ret[i]);
        //             sb.append(" = ");
        //             // sb.append(ret[i+1]);
        //             log.info(sb.toString());
        //             sb.delete(0, sb.length());
        //         }
        //     }
        // }


        String[] pair_dict = j.split(",");
        for (int i = 0; i < pair_dict.length; i++){

            String[] data = pair_dict[i].split(":");

            for (int k = 0; k < data.length-1; k++){
                sb.append(q);
                sb.append(data[k]);
                sb.append(" = ");
                sb.append(data[k+1]);
                log.info(sb.toString());
                sb.delete(0, sb.length());
            }
        }

        return "";
    }
}