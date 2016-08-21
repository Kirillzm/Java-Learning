package com.javarush.test.level09.lesson11.home08;

import java.util.ArrayList;

/* Список из массивов чисел
Создать список, элементами которого будут массивы чисел. Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно. Заполнить массивы любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<int[]> list = createList();
        printList(list);
    }

    public static ArrayList<int[]> createList()
    {
        ArrayList<int[]> array = new ArrayList<>();
        int[] array5 = new int[5];
        for (int i = 0; i < array5.length; i++) {
            array5[i] = 5;
        }

        int[] array2 = new int[2];
        for (int i = 0; i < array2.length; i++) {
            array2[i] = 2;
        }

        int[] array4 = new int[4];
        for (int i = 0; i < array4.length; i++) {
            array4[i] = 4;
        }

        int[] array7 = new int[7];
        for (int i = 0; i < array7.length; i++) {
            array7[i] = 7;
        }

        int[] array0 = new int[0];
        for (int i = 0; i < array0.length; i++) {
            array0[i] = 0;
        }
        array.add(array5);
        array.add(array2);
        array.add(array4);
        array.add(array7);
        array.add(array0);

        return array;
    }

    public static void printList(ArrayList<int[]> list)
    {
        for (int[] array: list )
        {
            for (int x: array)
            {
                System.out.println(x);
            }
        }
    }
}
