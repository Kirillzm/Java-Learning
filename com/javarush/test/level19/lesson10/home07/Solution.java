package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream(args[0]);
        FileOutputStream outputStream = new FileOutputStream(args[1]);

        byte[] buffer = new byte[inputStream.available()];

        inputStream.read(buffer);

        String bufferStr = new String(buffer, "windows-1251");
        bufferStr = bufferStr.replaceAll("\r", " ");
        if(!bufferStr.trim().isEmpty()) {
            String[] words = bufferStr.split(" ");

            String result = "";

            for (int i = 0; i < words.length; i++) {
                if (words[i].length() > 6) {
                    result += words[i] + ",";
                }
            }

            if(result.length() > 6) {
                result = result.substring(0, result.length()-1);
            }

            result = result.trim();
            outputStream.write(result.getBytes());
        }

        inputStream.close();
        outputStream.close();

    }
}
