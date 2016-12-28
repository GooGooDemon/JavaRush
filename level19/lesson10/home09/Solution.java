package com.javarush.test.level19.lesson10.home09;

/* Контекстная реклама
В методе main подмените объект System.out написанной вами реадер-оберткой
Ваша реадер-обертка должна выводить на консоль контекстную рекламу после каждого второго println-а
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Рекламный текст: "JavaRush - курсы Java онлайн"

Пример вывода:
first
second
JavaRush - курсы Java онлайн
third
fourth
JavaRush - курсы Java онлайн
fifth
*/
// сделал, но не отправил
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        final PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream myPrintStream = new PrintStream(outputStream) {
            private int count = 0;
            @Override
            public void print(String s)
            {
                count++;
                if (count % 2 == 0) {
                    super.print(s + "\nJavaRush - курсы Java онлайн");
                    count = 0;
                }
                else
                {
                    super.print(s);
                }
            }
        };

        System.setOut(myPrintStream);

        testString.printSomething();

        String result = outputStream.toString();

        System.setOut(consoleStream);

        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
