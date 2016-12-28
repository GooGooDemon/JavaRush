package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

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

        if ("-c".equals(args[0]))
        {
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

            int newId = getMaxId(list) + 1;
            String productName = args[1];
            Double productPrice = Double.parseDouble(args[2]);
            int quantity = Integer.parseInt(args[3]);

            Tovar tovar = new Tovar(newId, productName, productPrice, quantity);
            BufferedWriter fileOut = new BufferedWriter(new FileWriter(fileName, true));
            fileOut.write(tovar.toString() + "\n");
            fileOut.close();
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
