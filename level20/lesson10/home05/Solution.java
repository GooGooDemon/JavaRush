package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям модификатор transient.
*/
public class Solution  {

    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }

    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws Exception
    {
        Solution.Person person = new Solution.Person("firstName", "lastName", "Russia", Solution.Sex.MALE);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:\\level20.lesson10.home05.dat"));
        oos.writeObject(person);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("d:\\level20.lesson10.home05.dat"));
        Solution.Person loaded = (Solution.Person) ois.readObject();
        ois.close();

    }
}

