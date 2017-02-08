package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter) {
        ArrayList<String> list = new ArrayList<>();

        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            list.add(token);
        }

        return list.toArray(new String[0]);
    }

    public static void main(String[] args)
    {
        String[] lines = getTokens("level22.lesson13.task01", ".");
        System.out.println(Arrays.toString(lines));
    }
}
