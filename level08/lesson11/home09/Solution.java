package com.javarush.test.level08.lesson11.home09;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
    public static void main(String[] args) throws Exception
    {
        System.out.println("JANUARY 1 2000 - odd " + isDateOdd("JANUARY 1 2000"));
        System.out.println("JANUARY 2 2020 - odd " + isDateOdd("JANUARY 2 2020"));
        System.out.println("JANUARY 30 2020 - odd " + isDateOdd("JANUARY 30 2020"));
        System.out.println("MAY 2 2020 - odd " + isDateOdd("MAY 2 2020"));
        System.out.println("MAY 3 2020 - odd " + isDateOdd("MAY 3 2020"));
    }

    public static boolean isDateOdd(String date) throws Exception
    {
        DateFormat format = new SimpleDateFormat("MMMM d yyyy", Locale.ENGLISH);
        Date endDate = format.parse(date);
        Date startDate = new Date(endDate.getTime());

        startDate.setYear(startDate.getYear()-1);
        startDate.setMonth(11);
        startDate.setDate(31);

        long timeDistance = endDate.getTime() - startDate.getTime();
        long msDay = 24 * 60 * 60 * 1000;  //сколько миллисекунд в одних сутках
        long dayCount = timeDistance / msDay;
        return dayCount % 2 > 0;
    }
}
