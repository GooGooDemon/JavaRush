package com.javarush.test.level14.lesson08.bonus01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Float.NaN;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        } catch (ArithmeticException e)
        {
            exceptions.add(e);
        }

        //Add your code here
        // 2
        try {
            ArrayList<Integer> arr = null;
            arr.get(5);
        }
        catch (NullPointerException e) {
            exceptions.add(e);
        }

        // 3
        try {
            int[] arr = new int[5];
            int x = arr[10];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }

        // 4
        try {
            int x = -100;
            int[] arr = new int[x];
        }
        catch (NegativeArraySizeException e) {
            exceptions.add(e);
        }

        // 5
        try {
            Object a = new String("asdf");
            Integer b = (Integer)a;
        }
        catch (ClassCastException e) {
            exceptions.add(e);
        }

        // 6
        try {
            FileInputStream file = new FileInputStream("D://asdfasd.txt");
        }
        catch (FileNotFoundException e) {
            exceptions.add(e);
        }

        // 7
        try {
            int x = Integer.parseInt("asdfasdf");
        }
        catch (NumberFormatException e) {
            exceptions.add(e);
        }

        // 8
        try {
            Object x[] = new String[10];
            x[0] = Integer.valueOf(100);

        } catch (ArrayStoreException e) {
            exceptions.add(e);
        }

        // 9.
        try {
            throw new UnsupportedOperationException("Invalid operation for sorted list.");
        } catch(UnsupportedOperationException e) {
            exceptions.add(e);
        }

        // 10.
        try {
            throw new SecurityException("SecurityException");
        } catch (SecurityException e) {
            exceptions.add(e);
        }
    }
}
