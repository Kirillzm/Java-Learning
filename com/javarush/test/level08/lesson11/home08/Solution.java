package com.javarush.test.level08.lesson11.home08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/* Пять наибольших чисел
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Вывести пять наибольших чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < array.length; i++)
        {
            array[i] = Integer.parseInt(reader.readLine());
        }



        sort(array);

        System.out.println("Sorted: ");

        for (int i = 0; i < array.length-1; i++) {
            System.out.println(array[i]);
        }
    }


    public static void sort(int[] array)
    {
        Arrays.sort(array);

        System.out.println("Unsorted: ");

        for (int i = 0; i < array.length-1; i++) {
            System.out.println(array[i]);
        }




    }
}
