package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/
// сделал, но не отправил
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length < 2) return;

        String fileName1 = args[0];
        String fileName2 = args[1];

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName2));

        String line;
        String result = "";
        while ((line = fileReader.readLine()) != null) {
            String[] words = line.split(" ");

            for (String word : words) {
                if (word.length() > 6) {
                    result = result + word + ",";
                }
            }
        }
        result = result.substring(0, result.length()-1);
        fileWriter.write(result);

        fileReader.close();
        fileWriter.close();
    }
}
