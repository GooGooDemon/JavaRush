package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String fileName = console.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName);

        HashMap<Integer, Integer> map = new HashMap<>();
        while (fileInputStream.available() > 0) {
            int readedByte = fileInputStream.read();
            if (map.containsKey(readedByte))
            {
                map.put(readedByte, map.get(readedByte)+1);
            }
            else
            {
                map.put(readedByte, 1);
            }
        }

        int min = Byte.MAX_VALUE;
        for (Integer x : map.values()) {
            if (x < min) min = x;
        }

        for (Map.Entry<Integer,Integer> pair : map.entrySet()) {
            if (pair.getValue() == min)
                System.out.print(pair.getKey() + " ");
        }

        fileInputStream.close();
    }
}
