package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/
// сделал, но не отправил

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = console.readLine();

        BufferedReader file1 = new BufferedReader(new FileReader(fileName1));

        int count = 0;
        while (file1.ready()) {
            String line = file1.readLine();
            Pattern pattern = Pattern.compile("\\bworld\\b");
            Matcher matcher = pattern.matcher(line);
            while(matcher.find())
            {
                //System.out.println(matcher.group());
                count++;
            }
        }

        System.out.println(count);

        file1.close();
        console.close();
    }
}
