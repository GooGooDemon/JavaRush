package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/
// сделал, но не отправил
public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws Exception {
        if (args.length == 0) return;

        String fileName = args[0];

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        String line;
        while ((line = fileReader.readLine()) != null) {
            String name = "";
            Date date = new Date();

            DateFormat df = new SimpleDateFormat("dd MM yyyy");
            Matcher matcher = Pattern.compile("\\d").matcher(line);
            if (matcher.find())
            {
                name = line.substring(0, matcher.start()-1);
                String dateString = line.substring(matcher.start());
                date = df.parse(dateString);
            }

            PEOPLE.add(new Person(name, date));
        }
        fileReader.close();
    }

}
