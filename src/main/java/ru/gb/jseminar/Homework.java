package ru.gb.jseminar;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;
import java.util.logging.Logger;
public class Homework {

    // Дана строка sql-запроса "select * from students".
    // Сформируйте часть WHERE этого запроса, используя StringBuilder.
    //
    // 1) Данные для фильтрации подаются в метод двумя массивами paramName и paramValue.
    // 2) Данные для фильтрации подаются в метод строкой в формате json.
    //      Пример json: {"firstName": "Ivan", "secondName": "Ivanov", ....}
    // Результат работы методов: "select * from students where firstName = 'Ivan' and ...".
    public static void main(String[] args) throws JsonProcessingException {
        Homework hw = new Homework();
        String query = "select * from students";
        String[] paramName = {"Ivan", "Maria", "Daria", "Ivan"};
        String[] paramValue = {"Ivanov", "Ivanova", "Petrova", "Sokolov"};
        String json = "{\"firstName\": \"Petr\", \"secondName\": \"Ivanov\"}";
        Logger log = Logger.getLogger(Homework.class.getName());
        log.info(hw.updateQueryByArrays(query, paramName, paramValue));
        log.info(hw.updateQueryByJson(query, json));
    }

    public String updateQueryByArrays(String q, String[] paramName, String[] paramValue){
        StringBuilder sb = new StringBuilder(q);
        sb.append(" WHERE");
        for (int i = 0; i<paramName.length; i++){
            sb.append(" firstname = ").append("'").append(paramName[i]).append("'");
            sb.append(" AND secondname = ").append("'").append(paramValue[i]).append("'");
            if (i<paramName.length-1) {
                sb.append(" AND");
            }
        }
        q = sb.toString();
        return q;
    }

    public String updateQueryByJson(String q, String json) throws JsonProcessingException {
        StringBuilder sb = new StringBuilder(q);
        sb.append(" WHERE");
        ObjectMapper objMapper = new ObjectMapper();
        Map<String, String> map = objMapper.readValue(json, new TypeReference<Map<String, String>>(){});
        Person person = objMapper.readValue(json, Person.class);
        sb.append(" firstname = ").append("'").append(person.getFirstName()).append("'");
        sb.append(" AND secondname = ").append("'").append(person.getSecondName()).append("'");
        q= sb.toString();
        return q;
    }
}
