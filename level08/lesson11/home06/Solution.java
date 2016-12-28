package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        Human grandFather1 = new Human("Дедушка1", true, 65);
        Human grandFather2 = new Human("Дедушка2", true, 70);
        Human grandMother1 = new Human("Бабушка1", false, 70);
        Human grandMother2 = new Human("Бабушка2", false, 70);
        Human father = new Human("Father", true, 35);
        Human mother = new Human("Mother", false, 33);
        Human child1 = new Human("child1", false, 10);
        Human child2 = new Human("child2", true, 8);
        Human child3 = new Human("child3", false, 5);

        grandFather1.children.add(father);
        grandMother1.children.add(father);
        grandFather2.children.add(mother);
        grandMother2.children.add(mother);
        father.children.add(child1);
        father.children.add(child2);
        father.children.add(child3);
        mother.children.add(child1);
        mother.children.add(child2);
        mother.children.add(child3);


        System.out.println(grandFather1);
        System.out.println(grandFather2);
        System.out.println(grandMother1);
        System.out.println(grandMother2);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
    }

    public static class Human
    {
        public String name;
        public boolean sex;
        public int age;
        public ArrayList<Human> children;

        public Human(String name, boolean sex, int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            children = new ArrayList<Human>();
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
