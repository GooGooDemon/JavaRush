package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources

*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, String> names = new TreeMap<>();

        String filename = console.readLine();
        while (!"end".equals(filename)) {
            names.put(getNumber(filename), filename);
            filename = console.readLine();
        }
        console.close();

        String resultFileName = getFileName(names.get(1));

        //System.out.println("Объединяем файлы в " + resultFileName);
        BufferedOutputStream resultStream = new BufferedOutputStream(new FileOutputStream(resultFileName));
        for (Map.Entry<Integer,String> pair : names.entrySet())
        {
            //System.out.print(pair.getValue() + " ... ");
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(pair.getValue()));
            byte[] buff = new byte[inputStream.available()];
            while (inputStream.available() > 0) {
                int count = inputStream.read(buff);
                resultStream.write(buff, 0, count);
            }
            inputStream.close();
            //System.out.println("закончено");
        }
        resultStream.close();
    }

    public static int getNumber(String fileName) {
        Pattern pattern = Pattern.compile("[0-9]+$"); // ищет число в конце строки, например Lion.avi.part37 => 37
        Matcher matcher = pattern.matcher(fileName);

        if (!matcher.find()) throw new RuntimeException("Неправильное имя файла. Не найдено число в конце имени файла");
        String number = fileName.substring(matcher.start(),matcher.end());
        return Integer.parseInt(number);
    }

    public static String getFileName(String fileName) {
        Pattern pattern = Pattern.compile(".part[0-9]+$"); // ищет .partXX в конце строки, например Lion.avi.part37 => .part37
        Matcher matcher = pattern.matcher(fileName);

        if (!matcher.find()) throw new RuntimeException("Неправильное имя файла. Не найдено число в конце имени файла");

        return matcher.replaceFirst("");
    }
}
