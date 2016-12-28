package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String line = console.readLine();
        int summa = 0;

        while (!line.equals("сумма"))
        {
            summa += Integer.parseInt(line);
            line = console.readLine();
        }

        System.out.println(summa);
    }
}
