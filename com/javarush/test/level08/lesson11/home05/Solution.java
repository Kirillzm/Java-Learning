package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        String[] split = line.split("");

        for (int i = 0; i < split.length; i++) {
            if(split[i].equals(" ") && !split[i+1].equals(" ")) {
                split[i+1] = split[i+1].toUpperCase();
            }
        }

        for (int i = 0; i < split.length; i++) {
            System.out.print(split[i]);
        }

    }


}
