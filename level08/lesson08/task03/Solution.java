package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static void main(String[] args)
    {
        HashMap<String, String> map = createMap();
        System.out.println("Владимир: " + getCountTheSameFirstName(map, "Владимир"));
        System.out.println("Иванов: " + getCountTheSameLastName(map, "Иванов"));
    }

    public static HashMap<String, String> createMap()
    {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("Иванов", "Иван");
        hashMap.put("Немчинов", "Сергей");
        hashMap.put("Петров", "Сергей");
        hashMap.put("Сидоров", "Владимир");
        hashMap.put("Михайлов", "Михаил");
        hashMap.put("Маринина", "Татьяна");
        hashMap.put("Лукашенко", "Николай");
        hashMap.put("Поддубный", "Иван");
        hashMap.put("Путин", "Владимир");
        hashMap.put("Лавров", "Сергей");
        return hashMap;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        int count = 0;

        for (Map.Entry<String, String> item : map.entrySet())
        {
            if (item.getValue().equals(name))
                count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        int count = 0;

        for (Map.Entry<String, String> item : map.entrySet())
        {
            if (item.getKey().equals(lastName))
                count++;
        }
        return count;
    }
}
