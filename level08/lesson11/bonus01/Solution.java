package com.javarush.test.level08.lesson11.bonus01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("January".toUpperCase(), 1);
        map.put("February".toUpperCase(), 2);
        map.put("March".toUpperCase(), 3);
        map.put("April".toUpperCase(), 4);
        map.put("May".toUpperCase(), 5);
        map.put("June".toUpperCase(), 6);
        map.put("July".toUpperCase(), 7);
        map.put("August".toUpperCase(), 8);
        map.put("September".toUpperCase(), 9);
        map.put("October".toUpperCase(), 10);
        map.put("November".toUpperCase(), 11);
        map.put("December".toUpperCase(), 12);

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String monthString = console.readLine();

        System.out.println(monthString + " is " + map.get(monthString.toUpperCase()) + " month");
    }

}
