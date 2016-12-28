package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String filename = console.readLine();
        FileOutputStream fs = new FileOutputStream(filename);

        ArrayList<String> strings = new ArrayList<>();

        String text = console.readLine();
        while (!text.equals("exit"))
        {
            strings.add(text + "\n");
            text = console.readLine();
        }
        strings.add(text);

        for (String str : strings)
        {
            fs.write(str.getBytes());
        }

        console.close();
        fs.close();
    }
}
