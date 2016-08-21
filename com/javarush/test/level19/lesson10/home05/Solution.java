package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));

        FileOutputStream outputStream = new FileOutputStream(args[1]);

        String result = "";

        while (fileReader.ready()) {
            String str = fileReader.readLine();
            String[] words = str.split(" ");


            for (int i = 0; i < words.length; i++) {
                if(words[i].contains("0") || words[i].contains("1") || words[i].contains("2") || words[i].contains("3") || words[i].contains("4") ||
                        words[i].contains("5") || words[i].contains("6") || words[i].contains("7") || words[i].contains("8") || words[i].contains("9"))  {

                    result += words[i] + " ";

                }
            }


        }

        result = result.trim();

        outputStream.write(result.getBytes());

        fileReader.close();
        outputStream.close();

    }
}
