package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());
        int c = Integer.parseInt(bufferedReader.readLine());

        if (a > b && a > c) System.out.println(a);
        if (b > a && b > c) System.out.println(b);
        if (c > a && c > b) System.out.println(c);

        if (((a > b) || (a > c)) && ((a < b) || (a < c))) System.out.println(a);
        if (((b > a) || (b > c)) && ((b < a) || (b < c))) System.out.println(b);
        if (((c > a) || (c > b)) && ((c < a) || (c < b))) System.out.println(c);

        if (a < b && a < c) System.out.println(a);
        if (b < a && b < c) System.out.println(b);
        if (c < a && c < b) System.out.println(c);
    }

    public static int max(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }

    public static int min(int a, int b) {
        if (a < b)
            return a;
        else
            return b;
    }
}
