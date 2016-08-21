package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        reader.close();

        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        String str = new String(buffer);
        str = str.replaceAll("[^A-Za-zА-Яа-я0-9]", " ");
        String[] split = str.split(" ");
        int countWorld = 0;
        for (int i = 0; i < split.length; i++) {
            if(split[i].equals("world")) {
                countWorld++;
            }
        }
        System.out.print(countWorld);
        inputStream.close();
    }
}
