package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = console.readLine();
        String fileName2 = console.readLine();

        FileInputStream fileInput = new FileInputStream(fileName1);
        FileOutputStream fileOutput1 = new FileOutputStream(fileName2);

        int size = fileInput.available();
        byte[] buff1 = new byte[size];
        byte[] buff2 = new byte[size];

        int count = fileInput.read(buff1);

        for (int i = 0; i < buff1.length; i++)
        {
            buff2[size-1-i] = buff1[i];
        }

        fileOutput1.write(buff2);

        fileInput.close();
        fileOutput1.close();
        console.close();
    }
}
