package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
    }

    public static boolean isDateOdd(String date)
    {
        Date yearStartYear = new Date();
        Date currentDate = new Date(date);
        yearStartYear.setHours(0);
        yearStartYear.setMinutes(0);

        yearStartYear.setSeconds(0);
        yearStartYear.setDate(1);
        yearStartYear.setMonth(0);
        long msTimeDistance = currentDate.getTime() - yearStartYear.getTime();
        long msDay = 24*60*60*1000;
        int days = (int)(msTimeDistance/msDay);
        System.out.println(days);
        if(days % 2 == 0){
            return false;
        }else {
            return true;
        }

    }
}
