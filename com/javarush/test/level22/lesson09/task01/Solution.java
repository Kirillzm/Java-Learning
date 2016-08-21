package com.javarush.test.level22.lesson09.task01;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream("C:/f1.txt");
        byte[] buffer = new byte[inputStream.available()];

        inputStream.read(buffer);
        String bufferStr = new String(buffer);

        bufferStr = bufferStr.replaceAll("\\n", " ");
        bufferStr = bufferStr.replaceAll("\\r", "");

        String[] split = bufferStr.split(" ");

        for (int i = 0; i < split.length; i++) {
            StringBuilder sb = new StringBuilder(split[i]);
            if(bufferStr.contains(sb.reverse().toString())) {
                Pair pair = new Pair();
                pair.first = split[i];
                pair.second = sb.reverse().toString();
                result.add(pair);
        }


        }
        for(Pair p : result) {
            System.out.println(p);
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
