package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        ArrayList<String> words = new ArrayList<>();
        ArrayList<Integer> numbers = new ArrayList<>();

        for (String s : array)
        {
            if (isNumber(s))
                numbers.add(Integer.parseInt(s));
            else
                words.add(s);
        }

        for (int i = 0; i < words.size(); i++)
            for (int j = 0; j < words.size(); j++)
            {
                if (isGreaterThan(words.get(j), words.get(i)))
                {
                    String s = words.get(j);
                    words.set(j, words.get(i));
                    words.set(i, s);
                }
            }

        for (int i = 0; i < numbers.size(); i++)
            for (int j = 0; j < numbers.size(); j++)
            {
                if (numbers.get(i) > numbers.get(j))
                {
                    int x = numbers.get(i);
                    numbers.set(i, numbers.get(j));
                    numbers.set(j, x);
                }
            }

        int wordIndex = 0;
        int numberIndex = 0;

        for (int i = 0; i < array.length; i++)
        {
            if (isNumber(array[i]))
                array[i] = numbers.get(numberIndex++).toString();
            else
                array[i] = words.get(wordIndex++);
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
