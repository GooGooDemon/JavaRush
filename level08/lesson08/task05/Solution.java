package com.javarush.test.level08.lesson08.task05;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        HashMap<String, String> hashMap = createMap();
        printMap(hashMap, "Hash map");

        removeTheFirstNameDuplicates(hashMap);
        printMap(hashMap, "items is removed");
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

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);

        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            String firstName = pair.getValue();
            if (getCountTheSameFirstName(copy, firstName) > 1)
            {
                System.out.println("remove: " + firstName);
                removeItemFromMapByValue(map, firstName);
            }
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void printMap(HashMap<String, String> map, String desc)
    {
        System.out.println(desc);
        for (Map.Entry<String, String> item : map.entrySet())
        {
            System.out.println(item.getKey() + " : " + item.getValue());
        }
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
}
