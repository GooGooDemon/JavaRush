package com.javarush.test.level03.lesson08.task01;

/* Как захватить мир
Ввести с клавиатуры число и имя, вывести на экран строку:
«имя» захватит мир через «число» лет. Му-ха-ха!
Пример: Вася захватит мир через 8 лет. Му-ха-ха!

Последовательность вводимых данных имеет большое значение.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        InputStream inputStream = System.in;
        Reader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        //System.out.print("Enter years: ");
        String yearsStr = bufferedReader.readLine();
        int years = Integer.parseInt(yearsStr);

        //System.out.print("Enter name: ");
        String name = bufferedReader.readLine();

        System.out.println(name + " захватит мир через " + years + " лет. Му-ха-ха!");
    }
}