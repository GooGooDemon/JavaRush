package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) return;

        String fileName = args[0];

        FileInputStream file = new FileInputStream(fileName);

        int countSpaces = 0;
        int countSymbols = 0;
        while (file.available() > 0) {
            countSymbols++;
            char c = (char)file.read();
            if (c == ' ')
                countSpaces++;
        }

        System.out.printf("%.2f", (double)countSpaces/countSymbols*100);

        file.close();
    }
}
