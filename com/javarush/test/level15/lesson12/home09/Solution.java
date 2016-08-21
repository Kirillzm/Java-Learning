package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        int lastIndex = url.indexOf("?");
        url = url.substring(lastIndex+1, url.length());
        String[] split = url.split("&");
        String[] param = new String[split.length];
        int index = 0;



        for (int i = 0; i < split.length; i++) {
            if(!split[i].contains("=")) {
                param[i] = split[i];
            }
            else {
                index = split[i].indexOf("=");
                param[i] = split[i].substring(0, index);
            }
        }


        String result = "";

        for (int i = 0; i < param.length; i++) {
            result += param[i] + " ";
        }

        System.out.println(result.trim());


        for (int i = 0; i < split.length; i++) {
            if(split[i].startsWith("obj=")) {
                try {
                    index = split[i].indexOf("=");
                    Double value = Double.parseDouble(split[i].substring(index+1));
                    alert(value);
                }
                catch (NumberFormatException  e) {
                    String value = split[i].substring(index+1);
                    alert(value);
                }
            }
        }




    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
