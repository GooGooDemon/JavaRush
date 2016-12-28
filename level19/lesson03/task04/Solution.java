package com.javarush.test.level19.lesson03.task04;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner scanner;

        public PersonScannerAdapter(Scanner scanner)
        {
            this.scanner = scanner;
        }


        @Override
        public Person read() throws IOException
        {
            Person person = null;
            if (scanner.hasNextLine())
            {
                String[] lines = scanner.nextLine().split(" ");

                String firstName = lines[1];
                String middleName = lines[2];
                String lastName = lines[0];
                String day = lines[3];
                String month = lines[4];
                String year = lines[5];
                Date birthDate = new Date();

                DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                try
                {
                    birthDate = df.parse(day + "-" + month + "-" + year);
                }
                catch (ParseException e) {
                    //System.out.println(e.getMessage());
                }
                person = new Person(firstName, middleName, lastName, birthDate);
            }
            return person;
        }

        @Override
        public void close() throws IOException
        {
            scanner.close();
        }
    }

    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(new FileInputStream("D:/scanner.txt"));

        PersonScannerAdapter adapter = new PersonScannerAdapter(scanner);
        Person person1 = adapter.read();
        Person person2 = adapter.read();
        Person person3 = adapter.read();
        System.out.println(person1.toString());
        System.out.println(person2.toString());
        System.out.println(person3.toString());
    }
}
