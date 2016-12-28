package com.javarush.test.level04.lesson07.task01;

/* Строка - описание
Ввести с клавиатуры целое число. Вывести на экран его строку-описание следующего вида:
«отрицательное четное число» - если число отрицательное и четное,
«отрицательное нечетное число» - если число отрицательное и нечетное,
«нулевое число» - если число равно 0,
«положительное четное число» - если число положительное и четное,
«положительное нечетное число» - если число положительное и нечетное.
Пример для числа 100:
положительное четное число
Пример для числа -51:
отрицательное нечетное число
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bufferedReader.readLine());

        boolean positive = a > 0;
        boolean zero = a == 0;
        boolean odd  = Math.abs(a % 2) > 0;

        String desc;

        if (zero)
        {
            desc = "нулевое число";
        }
        else
        {
            if (positive)
                desc = "положительное";
            else
                desc = "отрицательное";

            if (odd)
                desc += " нечетное";
            else
                desc += " четное";

            desc += " число";
        }

        System.out.println(desc);
    }
}
