package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileWriter fw = new FileWriter(reader.readLine());
        String str;
        while (true) {
             str = reader.readLine();

            if(str.equals("exit")) {
                fw.append("exit");
                fw.flush();
                break;
            }

            fw.append(str);
            fw.append("\r\n");
            fw.flush();
        }
        reader.close();
        fw.close();





    }
}
