package com.javarush.test.level08.lesson08.task04;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static void main(String[] args)
    {
        HashMap<String, Date> map = createMap();
        removeAllSummerPeople(map);
    }

    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("1", new Date("JUNE 1 1980"));
        map.put("2", new Date("JUNE 1 1950"));
        map.put("3", new Date("JUNE 5 1957"));
        map.put("4", new Date("JANUARY 5 1957"));
        map.put("5", new Date("MAY 5 1957"));
        map.put("6", new Date("MAY 5 1957"));
        map.put("7", new Date("SEPTEMBER 5 1957"));
        map.put("8", new Date("JULY 5 1957"));
        map.put("9", new Date("AUGUST 5 1957"));
        map.put("10", new Date("NOVEMBER 5 1957"));
        return  map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        Iterator<Map.Entry<String, Date>> itr = map.entrySet().iterator();
        while (itr.hasNext())
        {
            Map.Entry<String, Date> item = itr.next();
            System.out.println(item.getKey() + " : " + item.getValue());

            if (item.getValue().getMonth() >= 5 && item.getValue().getMonth() <= 7)
            {
                System.out.println("remove " + item.getKey());
                itr.remove();
            }
        }
    }
}
