package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        FileOutputStream outputStream = new FileOutputStream(reader.readLine());
        reader.close();

        byte[] buffer = new byte[inputStream.available()];

        inputStream.read(buffer);

        String bufferString = new String(buffer);
        String[] arrayStr = bufferString.split(" ");

        String result = "";

        for (int i = 0; i < arrayStr.length; i++) {
            try {
                int a = Integer.parseInt(arrayStr[i]);
                result += a + " ";
            }
            catch (NumberFormatException e) {

            }
        }

        result = result.trim();

        outputStream.write(result.getBytes());

        inputStream.close();
        outputStream.close();

    }
}
