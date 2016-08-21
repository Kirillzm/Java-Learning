package com.javarush.test.level22.lesson09.task02;

import java.util.HashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {

    public static void main(String[] args) {
        Map<String, String> test = new HashMap<>();
        test.put("name", "Ivanov");
        test.put(null, "Ukraine");
        test.put("city", "Kiev");
        test.put("age", null);

        System.out.println(getCondition(test));
    }

    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder result = new StringBuilder();

        if(!params.isEmpty()) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (key != null && value != null) {
                    result.append(entry.getKey() + " = " + "'" + entry.getValue() + "'" + " and ");
                }
            }

            result = result.delete(result.length() - 5, result.length());
        }

        return result;
    }
}
