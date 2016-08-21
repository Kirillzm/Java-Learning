package com.javarush.test.level19.lesson10.home06;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла
3. Заменить все числа на слова используя словарь map
4. Результат вывести на экран
5. Закрыть потоки. Не использовать try-with-resources

Пример данных:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws Exception {
        String fileName = new Scanner(System.in).nextLine();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            String[] words = line.split(" ");
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                String replaceValue = null;
                try {
                    Integer num = Integer.parseInt(word);
                    replaceValue = map.get(num);
                } catch (NumberFormatException ignored) {
                }

                if (replaceValue != null) {
                    sb.append(replaceValue);
                } else {
                    sb.append(word);
                }

                if (i < words.length - 1) {
                    sb.append(' ');
                }
            }

            sb.append('\n');
        }

        reader.close();

        System.out.println(sb.toString());
//
////        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        FileInputStream inputStream = new FileInputStream(reader.readLine());
//        reader.close();
//
//        byte[] buffer = new byte[inputStream.available()];
//
//        inputStream.read(buffer);
//
//        String str = new String(buffer, "windows-1251");
//
//        String[] lines = str.split("\n");
//        String[] result = new String[lines.length];
//        for (int a = 0; a < lines.length; a++) {
//            String[] words = lines[a].split(" ");
//            result[a] = "";
//
//            for (int i=0; i<words.length;i++) {
//                try {
//                    if (map.containsKey(Integer.parseInt(words[i]))) {
//                        words[i] = words[i].replace(words[i], map.get(Integer.parseInt(words[i])));
//                        result[a] += words[i] + " ";
//                    }
//                    else {
//                        result[a] += words[i] + " ";
//                    }
//                }
//                catch (NumberFormatException e) {
//                    result[a] += words[i] + " ";
//                }
//            }
//            result[a] = result[a].replace("\r", "");
//            result[a] = result[a].trim();
//
//            System.out.println(result[a]);
//
//        }

//        inputStream.close();
    }
}
