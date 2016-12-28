package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/
// сделал, но не отправил

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) return;

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = console.readLine();
        console.close();

        BufferedReader file = new BufferedReader(new FileReader(fileName));
        ArrayList<Tovar> list = new ArrayList<>();
        String line;
        while ((line = file.readLine()) != null)
        {
            list.add(new Tovar(line));
        }
        file.close();

        if ("-u".equals(args[0]))
        {
            int id = Integer.parseInt(args[1]);
            String productName = args[2];
            Double productPrice = Double.parseDouble(args[3]);
            int quantity = Integer.parseInt(args[4]);

            Tovar tovar = getTovar(list, id);
            if (tovar != null) {
                tovar.setName(productName);
                tovar.setPrice(productPrice);
                tovar.setQuantity(quantity);
            }

            saveToFile(list, fileName);
        }

        if ("-d".equals(args[0]))
        {
            int id = Integer.parseInt(args[1]);
            Tovar tovar = getTovar(list, id);
            if (tovar != null) {
                list.remove(tovar);
            }
            saveToFile(list, fileName);
        }
    }

    private static int getMaxId(ArrayList<Tovar> list) {
        int max = Integer.MIN_VALUE;
        for (Tovar item : list) {
            if (item.getId() > max)
                max = item.getId();
        }
        return max;
    }

    private static Tovar getTovar(ArrayList<Tovar> list, int id) {
        for (Tovar item : list) {
            if (item.getId() == id)
                return item;
        }
        return null;
    }

    private static void saveToFile(ArrayList<Tovar> list, String fileName) throws IOException {
        BufferedWriter fileOut = new BufferedWriter(new FileWriter(fileName));
        for (Tovar item : list) {
            fileOut.write(item.toString() + "\n");
        }
        fileOut.close();
    }

    static class Tovar {
        private int Id;
        private String Name;
        private double Price;
        private int Quantity;

        public Tovar(String str)
        {
            String idString = str.substring(0, 8);
            str = str.substring(8);
            String nameString = str.substring(0, 30);
            str = str.substring(30);
            String priceString = str.substring(0, 8);
            str = str.substring(8);
            String quantityString = str;

            Id = Integer.parseInt(idString.trim());
            Name = nameString.trim();
            Price = Double.parseDouble(priceString.trim());
            Quantity = Integer.parseInt(quantityString.trim());
        }

        public Tovar(int id, String name, double price, int quantity)
        {
            Id = id;
            Name = name;
            Price = price;
            Quantity = quantity;
        }

        public int getId()
        {
            return Id;
        }

        public void setId(int id)
        {
            Id = id;
        }

        public String getName()
        {
            return Name;
        }

        public void setName(String name)
        {
            Name = name;
        }

        public double getPrice()
        {
            return Price;
        }

        public void setPrice(double price)
        {
            Price = price;
        }

        public int getQuantity()
        {
            return Quantity;
        }

        public void setQuantity(int quantity)
        {
            Quantity = quantity;
        }

        @Override
        public String toString()
        {
            return String.format(Locale.ENGLISH, "%-8d%-30s%-8.2f%-4d", Id, Name, Price, Quantity);
        }
    }
}
