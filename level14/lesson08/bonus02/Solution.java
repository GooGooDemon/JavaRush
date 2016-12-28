package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(console.readLine()); // 15
        int y = Integer.parseInt(console.readLine()); // 50

        int min = x > y ? y : x;

        for (int i = min; i > 0; i--) {
            if (x % i == 0 && y % i == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
