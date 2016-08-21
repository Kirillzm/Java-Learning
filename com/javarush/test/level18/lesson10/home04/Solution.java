package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        reader.close();

        FileInputStream inputStream2 = new FileInputStream(file1);

        byte[] buffer = new byte[inputStream2.available()];
            inputStream2.read(buffer, 0, inputStream2.available());

        inputStream2.close();


        FileOutputStream outputStream = new FileOutputStream(file1);
        FileInputStream inputStream = new FileInputStream(file2);


        while (inputStream.available() > 0) {
            outputStream.write(inputStream.read());
        }

        for (int i = 0; i < buffer.length; i++) {
            outputStream.write(buffer[i]);
        }

        inputStream.close();
        outputStream.close();

    }
}
