package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
1. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String filename = console.readLine();

        FileInputStream fs = new FileInputStream(filename);

        while (fs.available() > 0)
        {
            System.out.print((char)fs.read());
        }

        console.close();
        fs.close();
    }
}
