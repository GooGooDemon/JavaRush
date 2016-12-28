package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки. Не использовать try-with-resources
Не используйте System.exit();
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String filename = console.readLine();

        while (!"exit".equals(filename)) {
            try
            {
                FileInputStream file = new FileInputStream(filename);
            }
            catch (FileNotFoundException e) {
                System.out.println(filename);
                break;
            }
            filename = console.readLine();
        }
        console.close();
    }
}
