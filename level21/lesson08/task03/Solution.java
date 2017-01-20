package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
Метод main не участвует в тестировании.
*/
public class Solution {
    public static class A implements Cloneable {
        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        protected A clone() throws CloneNotSupportedException
        {
            return (A)super.clone();
        }
    }

    public static class B extends A {
        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected B clone() throws CloneNotSupportedException
        {
            throw new CloneNotSupportedException();
        }
    }

    public static class C extends B {
        public C(int i, int j, String name) {
            super(i, j, name);
        }

        @Override
        protected C clone() throws CloneNotSupportedException
        {
            C clone = new C(this.getI(), getJ(), getName());
            return clone;
        }
    }

    public static void main(String[] args) throws Exception
    {
        A objectA = new A(5, 10);
        B objectB = new B(3, 7, "object B");
        C objectC = new C(4, 8, "object C");

        A cloneA = objectA.clone();
        C cloneC = objectC.clone();
        B cloneB = objectB.clone();

        System.out.println(cloneA);
        System.out.println(cloneB);
        System.out.println(cloneC);
    }
}
