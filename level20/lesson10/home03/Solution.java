package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable {

    public static class A {
        protected String name = "A";

        public A() {

        }

        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {

        public B(String name) {
            super(name);
            this.name += name;
        }

        /**
         Переопределяем сериализацию.
         Для этого необходимо объявить методы:
         private void writeObject(ObjectOutputStream out) throws IOException
         private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
         Теперь сериализация/десериализация пойдет по нашему сценарию :)
         */
        private void writeObject(ObjectOutputStream out) throws IOException {
            out.defaultWriteObject();
            out.writeObject(name);
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject();
            name = (String)in.readObject();
        }
    }

    public static void main(String[] args) throws Exception
    {
        B b = new Solution().new B("Object B");

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\level20.lesson10.home03.dat"));
        oos.writeObject(b);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\level20.lesson10.home03.dat"));
        B loadedB = (B) ois.readObject();
        ois.close();
    }
}
