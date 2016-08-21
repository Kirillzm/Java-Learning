package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        String fileName = args[0];

        FileInputStream inputStream = new FileInputStream(fileName);
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);



        String bufferChar = new String(buffer).toLowerCase();

        int count = 0;

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String[] tmp = new String[bufferChar.length()];

        for (int i = 0; i < bufferChar.length(); i++) {
            tmp[i] = bufferChar.substring(i, i+1);
            if(alphabet.contains(tmp[i])) {
                count++;
            }
        }

        System.out.print(count);
        inputStream.close();

    }
}
