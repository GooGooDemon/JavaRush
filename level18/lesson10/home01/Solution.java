package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) return;

        String fileName = args[0];

        FileInputStream file = new FileInputStream(fileName);

        int count = 0;
        while (file.available() > 0) {
            char c = (char)file.read();
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))
                count++;
        }

        System.out.println(count);

        file.close();
    }
}
