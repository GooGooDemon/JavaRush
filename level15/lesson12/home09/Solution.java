package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14

http://javarush.ru/alpha/index.html?lvl=15&view&name=Aobjmigo&obj=3.14&name=&obj=djsdcd&oobj=3.0&obj=1&obj=2.3&obj=aaa
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        // считываем URl
        String line = console.readLine();
        if (!line.contains("?")) return;

        line = line.substring(line.indexOf("?")+1);

        // разбиваем строку параметров на отдельные строки param=value
        ArrayList<String> strings = new ArrayList<>();
        while (line.contains("&")) {
            String pair = line.substring(0, line.indexOf("&"));
            strings.add(pair);
            line = line.substring(line.indexOf("&")+1);
        }
        strings.add(line);

        boolean haveObj = false;
        String paramsStr = "";
        for (String str : strings)
        {
            paramsStr += getParam(str) + " ";
            if (!haveObj && getParam(str).equals("obj")) haveObj = true;
        }
        System.out.println(paramsStr.trim());

        if (haveObj) {
            for (String str : strings)
            {
                if (getParam(str).equals("obj"))
                {
                    String value = getValue(str);
                    try {
                        alert((double)Double.parseDouble(value));
                    }
                    catch (NumberFormatException e)
                    {
                        alert(value);
                    }
                }
            }
        }
    }

    private static String getValue(String str) {
        if (str.contains("="))
            return str.substring(str.indexOf("=") + 1);
        else
            return "";
    }

    private static String getParam(String str) {
        if (str.contains("="))
            return str.substring(0, str.indexOf("="));
        else
            return str;
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
