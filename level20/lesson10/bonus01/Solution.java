package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.Arrays;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static int[] getNumbers(int N) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int n = 1; n < N; n++)
        {
            String str = Integer.toString(n);
            int length = str.length();
            long sum = 0;
            for (int i = 0; i < str.length(); i++)
            {
                String num = str.substring(i, i+1);
                sum += Math.pow(Integer.parseInt(num), length);
            }
            if (sum == n) {
                list.add(n);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
            result[i] = list.get(i);
        }
        return result;
    }

    public static void main(String[] args)
    {
        long timeStart = System.currentTimeMillis();
        int[] numbers = getNumbers(150000);
        long timeEnd = System.currentTimeMillis();
        long memoryStart = Runtime.getRuntime().totalMemory();
        long memoryEnd = Runtime.getRuntime().freeMemory();

        System.out.println(timeEnd - timeStart + "ms");
        System.out.println((memoryStart - memoryEnd) / 1024 + "kb");


        //int[] numbers = getNumbers(2_000_000_000);
        System.out.println(Arrays.toString(numbers));
    }
}
