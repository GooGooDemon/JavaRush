package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String filename = console.readLine();

        while (!"exit".equals(filename)) {
            new ReadThread(filename).start();
            filename = console.readLine();
        }
        console.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run()
        {
            try
            {
                FileInputStream file = new FileInputStream(fileName);

                Map<Integer, Integer> bytesMap = new HashMap<>();

                while (file.available() > 0) {
                    int b = file.read();
                    if (bytesMap.containsKey(b)) {
                        bytesMap.put(b, bytesMap.get(b)+1);
                    }
                    else {
                        bytesMap.put(b, 1);
                    }
                }
                file.close();

                int count = 0;
                int value = 0;
                for (Map.Entry<Integer,Integer> entry : bytesMap.entrySet()) {
                    if (entry.getValue() > count) {
                        count = entry.getValue();
                        value = entry.getKey();
                    }
                }
                synchronized (Solution.class)
                {
                    resultMap.put(fileName, value);
                }
            }
            catch (IOException e) {

            }
        }
    }
}
