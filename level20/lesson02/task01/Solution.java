package com.javarush.test.level20.lesson02.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Читаем и пишем в файл: Human
Реализуйте логику записи в файл и чтения из файла для класса Human
Поле name в классе Human не может быть пустым
В файле your_file_name.tmp может быть несколько объектов Human
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {

            // File myFile = File.createTempFile("d:/level20.lesson02.task01.txt", null);
            FileOutputStream outputStream = new FileOutputStream("d:/level20.lesson02.task01.txt");

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.close();

            InputStream inputStream = new FileInputStream("d:/level20.lesson02.task01.txt");
            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();

            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны

            if (somePerson.equals(ivanov)) {
                System.out.println("Всё верно! somePerson равен ivanov");
            }
            else
                System.out.println("somePerson и ivanov различаются!");


        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);

            writer.println(name);
            writer.println(assets.size());

            for (Asset asset : assets) {
                writer.println(asset.getName());
                writer.println(asset.getPrice());
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            name = reader.readLine();

            int count = Integer.parseInt(reader.readLine());
            for (int i = count; i > 0; i--) {
                String assetName = reader.readLine();
                String assetPrice = reader.readLine();

                Asset asset = new Asset(assetName);
                asset.setPrice(Double.parseDouble(assetPrice));
                assets.add(asset);
            }
        }

        @Override
        public boolean equals(Object obj)
        {
            if (this == obj) return true;
            if (obj == null) return false;
            if (getClass() != obj.getClass())
                return false;

            Human other = (Human) obj;

            boolean cmp = name.equals(other.name);
            if (!cmp) {
                return false;
            }

            cmp = assets.equals(other.assets);
            if (!cmp) {
                return false;
            }

            return true;
        }
    }
}
