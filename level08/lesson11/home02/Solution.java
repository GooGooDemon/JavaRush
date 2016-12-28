package com.javarush.test.level08.lesson11.home02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Множество всех животных
1. Внутри класса Solution создать public static классы Cat, Dog.
2. Реализовать метод createCats, котороый должен возвращать множество с 4 котами.
3. Реализовать метод createDogs, котороый должен возвращать множество с 3 собаками.
4. Реализовать метод join, котороый должен возвращать объединенное множество всех животных - всех котов и собак.
5. Реализовать метод removeCats, котороый должен удалять из множества pets всех котов, которые есть в множестве cats.
6. Реализовать метод printPets, котороый должен выводить на экран всех животных, которые в нем есть. Каждое животное с новой строки
*/

public class Solution
{
    public static void main(String[] args)
    {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static Set<Cat> createCats()
    {
        HashSet<Cat> result = new HashSet<Cat>();
        result.add(new Cat("Cat 1"));
        result.add(new Cat("Cat 2"));
        result.add(new Cat("Cat 3"));
        result.add(new Cat("Cat 4"));
        return result;
    }

    public static Set<Dog> createDogs()
    {
        HashSet<Dog> result = new HashSet<Dog>();
        result.add(new Dog("Dog 1"));
        result.add(new Dog("Dog 2"));
        result.add(new Dog("Dog 3"));
        return result;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs)
    {
        Set<Object> set = new HashSet<>();
        for (Cat cat: cats)
            set.add(cat);

        for (Dog dog : dogs)
            set.add(dog);

        return set;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats)
    {
        Iterator<Object> objectIterator = pets.iterator();
        while (objectIterator.hasNext())
        {
            Object pet = objectIterator.next();
            if (cats.contains(pet))
                objectIterator.remove();
        }
    }

    public static void printPets(Set<Object> pets)
    {
        for (Object o : pets )
        {
            System.out.println(o);
        }
    }

    public static class Cat  {
        public String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String whoIam()
        {
            return "I am a cat";
        }

        public String toString()
        {
            return name + ", " + whoIam();
        }
    }

    public static class Dog {
        public String name;

        public Dog(String name)
        {
            this.name = name;
        }

        public String whoIam()
        {
            return "I am a dog";
        }

        public String toString()
        {
            return name + ", " + whoIam();
        }
    }
}
