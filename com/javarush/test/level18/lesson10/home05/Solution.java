package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
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
        String str = new String(buffer);
        String[] numStr = str.split(" ");

        int[] num = new int[numStr.length];

        byte[] tmp = new byte[numStr.length];
        String result = "";

        for (int i = 0; i < num.length; i++) {

            num[i] = Math.round(Float.parseFloat(numStr[i]));


            numStr[i] = String.valueOf(num[i]);
            result += numStr[i] + " ";


        }
        result = result.trim();
        tmp = result.getBytes();

        outputStream.write(tmp);



        inputStream.close();
        outputStream.close();



    }
}
