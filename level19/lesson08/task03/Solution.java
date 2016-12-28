package com.javarush.test.level19.lesson08.task03;

/* Выводим только цифры
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить только цифры
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Вывести модифицированную строку в консоль.

Пример вывода:
12345678
*/
// сделал, но не отправил
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            public void println(String s)
            {
                super.println(s.replaceAll("\\D", ""));
            }
        };

        //Устанавливаем его как текущий System.out
        System.setOut(printStream);

        testString.printSomething();

        //Преобразовываем записанные в наш ByteArray данные в строку
        String result = byteArrayOutputStream.toString().replaceAll("\\D", "");

        //Возвращаем все как было
        System.setOut(consoleStream);

        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }

}
