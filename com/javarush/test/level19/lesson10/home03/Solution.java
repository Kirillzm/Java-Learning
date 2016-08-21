package com.javarush.test.level19.lesson10.home03;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws Exception {
        FileInputStream inputStream = new FileInputStream(args[0]);
        byte[] buffer = new byte[inputStream.available()];

        inputStream.read(buffer);

        String bufferStr = new String(buffer);
        String[] lines = bufferStr.split("\n");

        int year = 0;
        int month = 0;
        int day = 0;
        String name = "";

        for (int i = 0; i < lines.length; i++) {
            String[] tmp = lines[i].split(" ");

                year = Integer.parseInt(tmp[tmp.length-1].replace("\r", ""));
                month = Integer.parseInt(tmp[tmp.length-2]);
                day = Integer.parseInt(tmp[tmp.length-3]);


            for (int j = 0; j < tmp.length-3; j++) {
                name += tmp[j] + " ";
            }

            name = name.trim();

            Calendar result = new GregorianCalendar();
            result.set(Calendar.YEAR, year);
            result.set(Calendar.MONTH, month - 1);
            result.set(Calendar.DAY_OF_MONTH, day);

            Person person = new Person(name, new Date(result.getTimeInMillis()));

            PEOPLE.add(person);

            name ="";

            inputStream.close();

        }



    }

}
