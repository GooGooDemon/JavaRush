package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws Exception
    {
        String fileName;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in)))
        {
            fileName = console.readLine();
            //fileName = "d:/level22.lesson09.task01.txt";
        }

        // read lines from file to list
        ArrayList<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            String str;
            while ((str = reader.readLine()) != null)
            {
                lines.add(str);
            }
        }

        // split lines to words by spaces and add they into HashMap
        Map<String, String> wordMap = new HashMap<>();
        for (String line: lines)
        {
            String[] wordsArray = line.split(" ");
            for (String w : wordsArray)
            {
                if (wordMap.containsKey(w))
                {
                    String valueRevers = new StringBuilder(w).reverse().toString();
                    if (w.equals(valueRevers))
                    {
                        wordMap.put(w, valueRevers);
                    }
                }
                else
                {
                    wordMap.put(w, null);
                }
            }
        }

        // find pairs
        String[] keys = Arrays.copyOf(wordMap.keySet().toArray(), wordMap.keySet().toArray().length, String[].class);
        for (String wordKey : keys)
        {
            for (String word : keys)
            {
                String valueRevers = new StringBuilder(word).reverse().toString();
                if (wordKey.equals(valueRevers) && !wordKey.equals(word))
                {
                    wordMap.put(wordKey, word);
                    wordMap.remove(word);
                }
            }
        }

        // add pair to result list
        for (Map.Entry<String, String> entry : wordMap.entrySet())
        {
            if (entry.getValue() != null) {
                Pair pair = new Pair();
                pair.first = entry.getKey();
                pair.second = entry.getValue();
                result.add(pair);
                System.out.println(pair);
            }
        }

        
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
