package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        //implement this method - реализуйте этот метод
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in)))
        {
            String fileName =  console.readLine();//"D:/level20.lesson02.task03.txt";
            console.close();

            FileInputStream inputStream = new FileInputStream(fileName);

            load(inputStream);
            //save(new FileOutputStream(new File("D:/level20.lesson02.task03_out.txt")));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        for (Map.Entry<String,String> item : properties.entrySet()) {
            prop.put(item.getKey(), item.getValue());
        }
        prop.store(outputStream, "comments");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.load(inputStream);

        for (Map.Entry<Object,Object> item : prop.entrySet()) {

            properties.put((String)item.getKey(), (String)item.getValue());
        }
    }

    public static void main(String[] args)
    {
        new Solution().fillInPropertiesMap();
    }
}
