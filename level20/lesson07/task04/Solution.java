package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Serializable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать, пометить ненужные поля — transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream)
2) создать экземпляр класса Solution - savedObject
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть)
4) создать другой экземпляр класса Solution с другим параметром
5) загрузить из потока на чтение объект - loadedObject
6) проверить, что savedObject.string равна loadedObject.string
7) обработать исключения
*/
public class Solution implements Serializable
{
    public static void main(String[] args) throws Exception {
        Solution savedObject = new Solution(4);
        System.out.println(savedObject);

        File file = File.createTempFile("level20.lesson07.task04.", "");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(savedObject);
        oos.close();
        fos.close();

        Solution loadedObject;// = new Solution(10);
        //System.out.println(loadedObject);

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        loadedObject = (Solution) ois.readObject();
        System.out.println(loadedObject);
        ois.close();
        fis.close();

        if (savedObject.equals(loadedObject))
            System.out.println("Равны");
        else
            System.out.println("Не равны!");
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null || getClass() != obj.getClass()) return false;

        return toString().equals(obj.toString());
    }
}
