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

            //File your_file_name = File.createTempFile("d:/level20.lesson02.task01.txt", null);
            OutputStream outputStream = new FileOutputStream("d:/level20.lesson02.task01.txt");
            InputStream inputStream = new FileInputStream("d:/level20.lesson02.task01.txt");

            Human ivanov = new Human("Ivanov", new Asset("home"), new Asset("car"));
            ivanov.save(outputStream);
            outputStream.flush();
            outputStream.close();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            inputStream.close();

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

            writer.print("human:" + name);
            writer.print("count:" + assets.size());

            for (Asset asset : assets) {
                writer.print("asset:" + asset.getName());
                writer.print("asset:" + asset.getPrice());
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = reader.readLine();
            if (line.contains("human:")) {
                name = line.replace("human:", "");
            }
            else
                return;

            line = reader.readLine().replaceFirst("count:", "");
            int count = Integer.parseInt(line);

            for (int i = count; i >= 0; i--) {
                String assetName = reader.readLine().replaceFirst("asset:", "");
                String assetPrice = reader.readLine().replaceFirst("asset:", "");

                Asset newAsset = new Asset(assetName);
                newAsset.setPrice(Double.parseDouble(assetPrice));
                assets.add(newAsset);
            }

        }
    }
}
