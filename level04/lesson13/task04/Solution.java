package com.javarush.test.level04.lesson13.task04;

import java.io.*;

/* Рисуем линии
Используя цикл for вывести на экран:
- горизонтальную линию из 10 восьмёрок
- вертикальную линию из 10 восьмёрок.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        for (int i = 0; i <= 10; i++)
        {
            for(int k = 0; k < 10; k++)
            {
                if (i==0 || k==0 )
                    System.out.print("8");
            }
            System.out.println();
        }
    }
}
