package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        if (N > 0)
        {
            int maximum = -2147483648;

            while (N > 0)
            {
                int x = Integer.parseInt(reader.readLine());
                if (x > maximum)
                    maximum = x;
                N--;
            }

            System.out.println(maximum);
        }
    }
}
