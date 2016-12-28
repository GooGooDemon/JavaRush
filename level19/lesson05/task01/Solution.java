package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/
// сделал, но не отправил
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = console.readLine();
        String fileName2 = console.readLine();
        console.close();

        FileReader file1 = new FileReader(fileName1);
        FileWriter file2 = new FileWriter(fileName2);

        int index = 1;
        while (file1.ready()) {
            if (index % 2 == 0)
                file2.write(file1.read());
            else
                file1.read();
            index++;
        }

        file1.close();
        file2.close();
    }
}
