package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("d:/level20.lesson02.task02.txt");


            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User user1 = new User();
            user1.setFirstName("Ivan");
            user1.setLastName("Ivanov");
            user1.setBirthDate(new SimpleDateFormat("dd.MM.yyyy").parse("15.03.1985"));
            user1.setMale(true);
            user1.setCountry(User.Country.RUSSIA);
            javaRush.users.add(user1);

            User user2 = new User();
            user2.setFirstName("Olga");
            user2.setLastName("Petrova");
            user2.setBirthDate(new SimpleDateFormat("dd.MM.yyyy").parse("14.09.1980"));
            user2.setMale(false);
            user2.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user2);

            javaRush.save(outputStream);
            outputStream.flush();
            outputStream.close();

            InputStream inputStream = new FileInputStream("d:/level20.lesson02.task02.txt");

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            if (loadedObject.equals(javaRush)) {
                System.out.println("Всё верно! loadedObject равен javaRush");
            }
            else
                System.out.println("javaRush и loadedObject различаются!");

            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);

            writer.println(users.size());
            writer.flush();

            for (User user : users)
            {
                user.save(outputStream);
            }
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            int count = Integer.parseInt(reader.readLine());

            for (int i = count; i > 0; i--)
            {
                User user = new User();
                user.load(reader);
                users.add(user);
            }
        }

        @Override
        public boolean equals(Object obj)
        {
            if (obj == null || getClass() != obj.getClass()) return false;

            JavaRush other = (JavaRush) obj;

            return users.equals(other.users);
        }
    }
}
