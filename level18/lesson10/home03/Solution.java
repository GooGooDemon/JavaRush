package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = console.readLine();
        String fileName2 = console.readLine();
        String fileName3 = console.readLine();

        BufferedOutputStream file1 = new BufferedOutputStream(new FileOutputStream(fileName1));
        BufferedInputStream file2 = new BufferedInputStream(new FileInputStream(fileName2));
        BufferedInputStream file3 = new BufferedInputStream(new FileInputStream(fileName3));

        while (file2.available() > 0) {
            byte[] buff = new byte[file2.available()];
            int count = file2.read(buff);
            file1.write(buff, 0, count);
        }

        while (file3.available() > 0) {
            byte[] buff = new byte[file3.available()];
            int count = file3.read(buff);
            file1.write(buff, 0, count);
        }

        file1.close();
        file2.close();
        file3.close();
        console.close();
    }
}
