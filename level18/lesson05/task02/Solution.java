package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String fileName = console.readLine();

        FileInputStream fileReader = new FileInputStream(fileName);

        int count = 0;

        while (fileReader.available() > 0) {
            int data = fileReader.read();
            if (data == ',') count++;
        }

        System.out.println(count);

        fileReader.close();
        console.close();
    }
}
