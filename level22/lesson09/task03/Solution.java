package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in)))
        {
            fileName = console.readLine();
            //fileName = "d:/level22.lesson09.task03.txt";
        }

        // read lines from file to list
        ArrayList<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            String str;
            while ((str = reader.readLine()) != null)
            {
                words.addAll(Arrays.asList(str.split(" ")));
            }
        }

        String[] wordsArray = Arrays.copyOf(words.toArray(), words.size(), String[].class);

        StringBuilder result = getLine(wordsArray);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words == null || words.length == 0) return new StringBuilder();

        // Создаём список через хешсет, убирая откровенные дубликаты строк
        ArrayList<String> preparedList = new ArrayList<>(new HashSet<>(Arrays.asList(words)));

        // Удаляем дубликаты строк в другом регистре
        for (int i = 0; i < preparedList.size(); i++)
        {
            String word1 = preparedList.get(i);
            if (word1 == null || word1.equals("")) {
                preparedList.remove(i);
                continue;
            }

            for (int j = i + 1; j < preparedList.size(); j++)
            {
                String word2 = preparedList.get(j);
                if (word2 == null || word2.equals("")) {
                    preparedList.remove(j);
                    continue;
                }

                if (word1.toUpperCase().equals(word2.toUpperCase()) && !word1.equals(word2)) {
                    preparedList.remove(word2);
                    j--;
                }
            }
        }
        Collections.sort(preparedList);

        ArrayList<String> list = new ArrayList<>(preparedList);
        StringBuilder sb = new StringBuilder();
        StringBuilder maxResult = new StringBuilder();
        int tries = 0;

        while (list.size() > 0)
        {
            Collections.shuffle(list);

            sb.append(list.get(0)).append(" ");

            String word = list.get(0);
            list.remove(word);

            int count = list.size();
            for (int i = 0; i < count; i++)
            {
                char last = word.toUpperCase().charAt(word.length() - 1);
                for (String w : list)
                {
                    char first = w.toUpperCase().charAt(0);
                    if (last == first)
                    {
                        word = w;
                        sb.append(w);
                        sb.append(" ");
                        list.remove(word);
                        break;
                    }
                }
            }
            if (list.size() == 0) {
                sb.deleteCharAt(sb.length()-1);
                return sb;
            }
            else {
                if (sb.length() > maxResult.length()) {
                    maxResult = sb;
                }
                sb = new StringBuilder();
                list.clear();
                list.addAll(preparedList);
                if (tries++ > 1000) break; // на случай несходимости списка
            }
        }
        maxResult.deleteCharAt(maxResult.length()-1);
        return maxResult;
    }
}
