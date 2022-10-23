package ru.gb.jseminar;

public class Homework {

    // Дана строка sql-запроса "select * from students".
    // Сформируйте часть WHERE этого запроса, используя StringBuilder.
    //
    // 1) Данные для фильтрации подаются в метод двумя массивами paramName и paramValue.
    // 2) Данные для фильтрации подаются в метод строкой в формате json.
    public static void main(String[] args) {

        String querry = "select * from students";
        Homework Homework2 = new Homework();
       
        //Через Array
        String[] paramName = {"Kurs", "Pol"};
        String[] paramValue = {"2", "Мужской"};
        System.out.println(Homework2.updateQueryByArrays(querry, paramName, paramValue));
        
        //Через JSON
        String json = "{\"Kurs\": \"2\", \"Pol\": \"Мужской\"}";
        System.out.println(Homework2.updateQueryByJson(querry, json));
    }

    public String updateQueryByArrays(String q, String[] paramName, String[] paramValue){
        
        if ((paramName.length == paramValue.length) && paramName.length != 0 )
        {
            try {
                StringBuilder where = new StringBuilder(q + " WHERE ");
                String  params = new String();
                for (int i=0; i < paramName.length; i++)
                {
                    params += paramName[i] +"=" + '"'+paramValue[i]+'"';
                    if (i < paramName.length - 1)
                        params += " AND ";                       
                }
                return  where.append(params).toString();
            } catch (ArrayIndexOutOfBoundsException exception) {
                return exception.toString();
            }
        }
        return null;
    }

    public String updateQueryByJson(String q,  String json){
        
        json = json.substring(1, json.length() - 1).trim();
        String[] param = json.split(",");
        String[] paramName = new String[param.length];
        String[] paramValue = new String[param.length];

        for (int i=0; i < param.length; i++)
        {
            String[] val = param[i].split(":");
            paramName[i] = val[0].replaceAll("\"", "").trim();
            paramValue[i] = val[1].replaceAll("\"", "").trim();
        }
        
        return this.updateQueryByArrays(q, paramName, paramValue);
    }
}
