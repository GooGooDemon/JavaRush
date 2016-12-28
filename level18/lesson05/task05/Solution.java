package com.javarush.test.level18.lesson05.task05;

/* DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки
2.2 выбросить исключение DownloadException
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException, DownloadException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String fileName;

        while ((fileName = console.readLine()).length() > 0) {
            File fileInput = new File(fileName);
            if (fileInput.length() < 1000)
            {
                console.close();
                throw new DownloadException();
            }
        }

        console.close();
    }

    public static class DownloadException extends Exception{

    }
}
