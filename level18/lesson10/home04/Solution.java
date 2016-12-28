package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = console.readLine();
        String fileName2 = console.readLine();

        // сначала читаем файл в буфер - сохраняем содержимое первого файла в памяти
        BufferedInputStream fileInput = new BufferedInputStream(new FileInputStream(fileName1));

        byte[] buffFirst = new byte[fileInput.available()];
        int countFirst = fileInput.read(buffFirst);

        fileInput.close();

        // Записываем содержимое второго файла в начало первого файла
        BufferedOutputStream file1 = new BufferedOutputStream(new FileOutputStream(fileName1));
        BufferedInputStream file2 = new BufferedInputStream(new FileInputStream(fileName2));

        while (file2.available() > 0) {
            byte[] buff = new byte[file2.available()];
            int count = file2.read(buff);
            file1.write(buff, 0, count);
        }

        // Записываем сохранённое содержимое первого файла в конец файла
        file1.write(buffFirst, 0, countFirst);

        file1.close();
        file2.close();

        console.close();
    }
}
