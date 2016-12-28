package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.*;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) return;

        String fileName = args[0];

        FileInputStream file = new FileInputStream(fileName);

        TreeMap <Character, Integer> map = new TreeMap<>();
        while (file.available() > 0) {
            Character c = (char)file.read();
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            }
            else {
                map.put(c, 1);
            }
        }

        for (char c: map.keySet())
        {
            System.out.println(c + " " + map.get(c));
        }

        file.close();
    }
}
