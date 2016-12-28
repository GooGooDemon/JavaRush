package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String fileName = console.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        int[] arrBytes = new int[255];
        while (fileInputStream.available() > 0) {
            int readedByte = fileInputStream.read();
            arrBytes[readedByte]++;
        }

        int max = 0;
        for (int x : arrBytes) {
            if (x > max) max = x;
        }

        for (int i = 0; i < arrBytes.length; i++)
        {
            if (arrBytes[i] == max)
                System.out.print(i + " ");
        }
        fileInputStream.close();
    }
}
