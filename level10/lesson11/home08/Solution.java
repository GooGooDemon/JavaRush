package com.javarush.test.level10.lesson11.home08;

import java.util.ArrayList;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        ArrayList[] arrayLists = new ArrayList[3];

        ArrayList<String> list1 = new ArrayList<>();
        list1.add("list1 string1");
        list1.add("list1 string2");
        list1.add("list1 string3");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add("list2 string1");
        list2.add("list2 string2");
        list2.add("list2 string3");

        ArrayList<String> list3 = new ArrayList<>();
        list3.add("list2 string1");
        list3.add("list2 string2");
        list3.add("list2 string3");

        arrayLists[0] = list1;
        arrayLists[1] = list2;
        arrayLists[2] = list3;

        return (ArrayList<String>[])arrayLists;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}