package com.javarush.test.level04.lesson10.task04;

import java.io.*;

/* S-квадрат
Вывести на экран квадрат из 10х10 букв S используя цикл while.
Буквы в каждой строке не разделять.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int x = 1;
        int y = 1;
        String str;

        while (x <= 10) {
            str = "";
            while (y <= 10) {
                str += "S";
                y++;
            }
            y = 1;
            x++;
            System.out.println(str);
        }

    }
}
