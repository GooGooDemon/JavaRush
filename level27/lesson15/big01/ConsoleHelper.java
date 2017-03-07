package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class ConsoleHelper
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws IOException
    {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException
    {
        writeMessage("Please choice dishes:");
        ConsoleHelper.writeMessage(Dish.allDishesToString());

        List<Dish> resultList = new ArrayList<>();

        String str;
        while (!(str = readString()).equalsIgnoreCase("EXIT"))
        {
            try
            {
                resultList.add(Dish.valueOf(str));
            }
            catch (IllegalArgumentException e)
            {
                writeMessage(String.format("%s is not detected", str));
            }
        }
        return resultList;
    }
}
