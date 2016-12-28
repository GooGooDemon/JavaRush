package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/
// сделал, но не отправил
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length < 2) return;

        String fileName1 = args[0];
        String fileName2 = args[1];

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2));

        String line;
        while ((line = fileReader.readLine()) != null) {
            String[] words = line.split(" ");

            for (String word : words) {
                Matcher matcher = Pattern.compile("\\d").matcher(word);
                if (matcher.find())
                    fileWriter.write(word + " ");
            }
        }

        fileReader.close();
        fileWriter.close();
    }
}
