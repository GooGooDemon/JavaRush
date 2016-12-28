package com.javarush.test.level03.lesson08.task02;

/* Зарплата через 5 лет
Ввести с клавиатуры отдельно Имя, число1, число2. Вывести надпись:
«Имя» получает «число1» через «число2» лет.
Пример: Коля получает 3000 через 5 лет.
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

        //System.out.print("Enter name: ");
        String name = bufferedReader.readLine();

        //System.out.print("Enter amoung of money: ");
        String moneyStr = bufferedReader.readLine();
        int money = Integer.parseInt(moneyStr);

        //System.out.print("Enter years: ");
        String yearsStr = bufferedReader.readLine();
        int years = Integer.parseInt(yearsStr);

        System.out.println(name + " получает " + money + " через " + years + " лет.");
    }
}