package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String filename = console.readLine();
        BufferedReader file = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));


        ArrayList<Integer> list = new ArrayList<>();

        String s = file.readLine();

        while (s != null && s.length() > 0) {
            list.add(Integer.parseInt(s));
            s = file.readLine();
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) > list.get(i))
                {
                    int t = list.get(j);
                    list.set(j, list.get(i));
                    list.set(i, t);
                }
            }
        }

        for (Integer x : list) {
            if (x % 2 == 0)
                System.out.println(x);
        }

        file.close();
    }
}
