package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = console.readLine();
        String fileName2 = console.readLine();
        String fileName3 = console.readLine();

        FileInputStream fileInput = new FileInputStream(fileName1);
        FileOutputStream fileOutput2 = new FileOutputStream(fileName2);
        FileOutputStream fileOutput3 = new FileOutputStream(fileName3);

        int size = fileInput.available();

        if (size > 0){
            if (size % 2 == 0){
                byte[] o1 = new byte[size/2];
                byte[] o2 = new byte[size/2];
                int count1 = fileInput.read(o1);
                int count2 = fileInput.read(o2);
                fileOutput2.write(o1, 0, count1);
                fileOutput3.write(o2, 0, count2);
            } else {
                byte[] o1 = new byte[size/2 + 1];
                byte[] o2 = new byte[size/2];
                int count1 = fileInput.read(o1);
                int count2 = fileInput.read(o2);
                fileOutput2.write(o1, 0, count1);
                fileOutput3.write(o2, 0, count2);
            }
        }

        fileInput.close();
        fileOutput2.close();
        fileOutput3.close();
        console.close();
    }
}
