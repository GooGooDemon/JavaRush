package com.javarush.test.level08.lesson08.task01;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        HashSet<String> set = new HashSet<>();

        set.add("Лягушка");
        set.add("Латиница");
        set.add("Лиственница");
        set.add("Луна");
        set.add("Лоза");
        set.add("Лора");
        set.add("Лодка");
        set.add("Лопата");
        set.add("Лапух");
        set.add("Ландух");
        set.add("Лужа");
        set.add("Лейка");
        set.add("Лето");
        set.add("Лазер");
        set.add("Лазейка");
        set.add("Липа");
        set.add("Лира");
        set.add("Лист");
        set.add("Листва");
        set.add("Лыко");

        return set;
    }
}
