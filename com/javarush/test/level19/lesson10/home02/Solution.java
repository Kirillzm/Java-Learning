package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception{
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
        double max = 0;
        String nameMax = "";
        for(Map.Entry<String, Double> entry : map.entrySet()) {
            double value = entry.getValue();
            if(value > max)  {
                max = value;
                nameMax = entry.getKey();
            }
        }

        System.out.print(nameMax);


        inputStream.close();
    }
}
