package com.javarush.test.level20.lesson10.home02;

import java.io.*;

/* Десериализация
На вход подается поток, в который записан сериализованный объект класса A либо класса B.
Десериализуйте объект в методе getOriginalObject предварительно определив, какого именно типа там объект.
Реализуйте интерфейс Serializable где необходимо.
*/
public class Solution implements Serializable {
    public A getOriginalObject(ObjectInputStream objectStream) throws IOException, ClassNotFoundException
    {
        Object obj = objectStream.readObject();

        if (obj instanceof B)
            return (B) obj;
        else if (obj instanceof A)
            return (A) obj;
        else
            throw new ClassNotFoundException();
    }

    public class A implements Serializable
    {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }
}

class Test
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Solution sol = new Solution();
        Solution.B b =  sol.new B();

        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("d:\\level20.lesson10.home02.dat"));
        oout.writeObject(b);
        oout.close();

        ObjectInputStream oin = new ObjectInputStream(new FileInputStream("d:\\level20.lesson10.home02.dat"));
        System.out.println(sol.getOriginalObject(oin).getClass().getCanonicalName());
        oin.close();
    }
}