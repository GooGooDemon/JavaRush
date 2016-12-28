package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        public String firstName;
        public String lastName;
        public boolean sex;
        public int weight;
        public int height;
        public int age;

        public Human () {};

        public Human(String firstName)
        {
            this.firstName = firstName;
        }


        public Human(String firstName, String lastName)
        {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public Human(String firstName, boolean sex)
        {
            this.firstName = firstName;
            this.sex = sex;
        }

        public Human(String firstName, String lastName, boolean sex)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
        }

        public Human(String firstName, String lastName, boolean sex, int age)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
            this.age = age;
        }

        public Human(String firstName, String lastName, boolean sex, int age, int weight)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
            this.age = age;
            this.weight = weight;
        }

        public Human(String firstName, String lastName, int age, int weight)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.weight = weight;
        }

        public Human(String firstName, String lastName, boolean sex, int age, int weight, int height)
        {
            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
            this.age = age;
            this.weight = weight;
            this.height = height;
        }

        public Human(String firstName, int weight, int height)
        {
            this.firstName = firstName;
            this.weight = weight;
            this.height = height;
        }
    }
}
