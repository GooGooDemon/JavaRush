package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;


/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String fileName = console.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName);

        HashMap<Integer, Integer> map = new HashMap<>();
        while (fileInputStream.available() > 0) {
            int readedByte = fileInputStream.read();
            if (!map.containsKey(readedByte))
            {
                map.put(readedByte, 0);
            }
        }

        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for (Object item : list) {
            System.out.print(item + " ");
        }

        fileInputStream.close();
    }
}
