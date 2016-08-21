package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        reader.close();

        String[] arrayStr = new String[3];
        arrayStr = str.split(" ");

        FileInputStream inputStream = new FileInputStream(arrayStr[1]);
        FileOutputStream outputStream = new FileOutputStream(arrayStr[2]);

        if (arrayStr[0].equals("-e")) {
            while (inputStream.available() > 0) {

                outputStream.write(inputStream.read());
                outputStream.write(2);
            }
        }

        if(arrayStr[0].equals("-d")) {
            for (int i = 0; i< inputStream.available(); i++) {
                outputStream.write(inputStream.read());
                outputStream.write(inputStream.read());
            }
        }
    }

}
