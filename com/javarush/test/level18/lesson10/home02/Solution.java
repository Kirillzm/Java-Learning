package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        int countSpace = 0;
        int allCharacterCount = 0;

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        int r;
        while ((r = reader.read()) != -1) {
            char ch = (char) r;
            if (ch == ' ') {
                countSpace++;
            }
            allCharacterCount++;
        }

        float result = (float) countSpace / allCharacterCount * 100;

        System.out.println(String.format("%(.2f", result));
        reader.close();

//        FileInputStream inputStream = new FileInputStream(args[0]);
//        byte[] buffer = new byte[inputStream.available()];
//        inputStream.read(buffer);
//
//        String bufferString = new String(buffer);
//        String[] tmp = bufferString.split("");
//        int countSpace = 0;
//        int all = tmp.length;
//
//        for (int i = 0; i < tmp.length; i++) {
//            if(tmp[i].equals(" ")) {
//                countSpace++;
//            }
//        }
//
//        float result = (float)countSpace/all*100;
//
//        System.out.println(String.format("%(.2f", result));
//
//        inputStream.close();
    }
}
