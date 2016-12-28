package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String fileName = console.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        int minByte = 0xFF;
        while (fileInputStream.available() > 0) {
            int readedByte = fileInputStream.read();
            if (readedByte < minByte) {
                minByte = readedByte;
            }
        }
        System.out.println(minByte);
        fileInputStream.close();
    }
}
