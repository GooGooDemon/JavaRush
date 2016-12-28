package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/
// сделал, но не отправил

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = console.readLine();
        String fileName2 = console.readLine();

        BufferedReader file1 = new BufferedReader(new FileReader(fileName1));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(fileName2));

        String line;
        Pattern pattern = Pattern.compile("[.]");
        while (file1.ready()) {
            line = file1.readLine();
            Matcher matcher = pattern.matcher(line);
            line = matcher.replaceAll("!");
            file2.write(line + "\n");
        }

        file1.close();
        file2.close();
        console.close();
    }
}
