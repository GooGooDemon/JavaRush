package com.javarush.test.level04.lesson16.home03;

import java.io.*;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int x = 0;
        int summa = 0;

        while (x != -1) {
            x = Integer.parseInt(console.readLine());
            summa += x;
        }

        System.out.println(summa);
    }
}
