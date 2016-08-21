package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        //Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(stream);

        testString.printSomething();

        String newText = outputStream.toString();
        int res = 0;

        if(newText.contains("+")) {
            res = Integer.parseInt(newText.substring(0,newText.indexOf("+")-1)) +
            Integer.parseInt(newText.substring(newText.indexOf("+")+2 , newText.indexOf("=")-1));
        }

        if(newText.contains("-")) {
            res = Integer.parseInt(newText.substring(0,newText.indexOf("-")-1)) -
                    Integer.parseInt(newText.substring(newText.indexOf("-")+2 , newText.indexOf("=")-1));
        }

        if(newText.contains("*")) {
            res = Integer.parseInt(newText.substring(0,newText.indexOf("*")-1)) *
                    Integer.parseInt(newText.substring(newText.indexOf("*")+2 , newText.indexOf("=")-1));
        }

        System.setOut(consoleStream);

        newText = newText.replace("\n", "").replace("\r", "");

        System.out.print(newText + "" + res);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

