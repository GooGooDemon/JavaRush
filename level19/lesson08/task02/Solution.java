package com.javarush.test.level19.lesson08.task02;

/* Ридер обертка 2
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна заменять все подстроки "te" на "??"
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Вывести модифицированную строку в консоль.
*/
// сделал, но не отправил

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;

        //Создаем динамический массив
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        //создаем адаптер к классу PrintStream
        PrintStream printStream = new PrintStream(byteArrayOutputStream) {
            @Override
            public void print(String s)
            {
                s = s.replaceAll("te", "??");
                super.print(s);
            }
        };

        //Устанавливаем его как текущий System.out
        System.setOut(printStream);

        testString.printSomething();

        //Преобразовываем записанные в наш ByteArray данные в строку
        String result = byteArrayOutputStream.toString();

        //Возвращаем все как было
        System.setOut(consoleStream);

        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
    }
    }
}
