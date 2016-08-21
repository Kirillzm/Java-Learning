package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader inputStream = new BufferedReader(new FileReader(reader.readLine()));
        reader.close();

        while (inputStream.ready()) {
            String result = inputStream.readLine();
            String[] words = new String[2];
            if(result.contains(":")) {
                words = result.split(":");
            }
            if(result.contains(" ")) {
                words = result.split(" ");
            }
            if(result.contains("=")) {
                words = result.split("=");
            }

            properties.put(words[0], words[1]);
        }

        inputStream.close();

    }

    public void save(OutputStream outputStream) throws Exception {
        PrintStream ps = new PrintStream(outputStream);
        for(Map.Entry<String,String> entry : properties.entrySet()) {
            ps.println(entry.getKey());
            ps.println(entry.getValue());
        }

        ps.flush();
        ps.close();


    }

    public void load(InputStream inputStream) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        while (reader.ready()) {
            String key = reader.readLine();
            String value = reader.readLine();
            properties.put(key, value);
        }

        reader.close();
    }
}
