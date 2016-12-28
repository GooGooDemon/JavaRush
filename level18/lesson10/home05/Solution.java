package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = console.readLine();
        String fileName2 = console.readLine();

        // Записываем содержимое второго файла в начало первого файла
        BufferedReader file1 = new BufferedReader(new FileReader(fileName1));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(fileName2));

        String[] lines = file1.readLine().split(" ");

        for (String line : lines) {
            int d = (int)Math.round(Double.parseDouble(line));
            file2.write(Integer.toString(d) + " ");
        }

        file1.close();
        file2.close();
        console.close();
    }
}
