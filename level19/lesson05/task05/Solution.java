package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
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
        Pattern pattern = Pattern.compile("\\p{Punct}");
        while (file1.ready()) {
            line = file1.readLine();
            Matcher matcher = pattern.matcher(line);
            while (matcher.find())
            {
                line = matcher.replaceAll("");
            }
            System.out.println(line);
            file2.write(line);
        }

        file1.close();
        file2.close();
        console.close();
    }
}
