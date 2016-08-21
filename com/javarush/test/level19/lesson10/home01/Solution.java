package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<String, Double> map = new HashMap<>();

        FileInputStream inputStream = new FileInputStream(args[0]);

        byte[] buffer = new byte[inputStream.available()];

        inputStream.read(buffer);

        String bufferStr = new String(buffer);

        String[] str = bufferStr.split("\n");

        String name;
        double money;

        for (int i = 0; i < str.length; i++) {
            name = str[i].split(" ")[0];
            money = Double.parseDouble(str[i].split(" ")[1]);

            if (!map.containsKey(name)) {
                map.put(name, money);
            } else {
                map.put(name, map.get(name) + money);
            }
        }

        Map<String, Double> treeMap = new TreeMap<String, Double>(map);

        for(Map.Entry<String, Double> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        inputStream.close();



    }
}
