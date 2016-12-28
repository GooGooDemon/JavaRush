package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/
// сделал, но не отправил
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream printStream = new PrintStream(outputStream) {
            @Override
            public void print(String s)
            {
                Matcher numberMatcher = Pattern.compile("\\d*").matcher(s);
                Matcher opMatcher = Pattern.compile("[+\\-*]").matcher(s);

                String number1 = "0";
                String number2 = "0";
                String operation = "";

                while (numberMatcher.find()) {
                    if (numberMatcher.group().length() > 0)
                    {
                        number1 = numberMatcher.group();
                        break;
                    }
                }

                while (numberMatcher.find()) {
                    if (numberMatcher.group().length() > 0)
                    {
                        number2 = numberMatcher.group();
                        break;
                    }
                }

                if (opMatcher.find())
                    operation = opMatcher.group();

                int n1 = Integer.parseInt(number1);
                int n2 = Integer.parseInt(number2);
                int result = 0;

                if ("+".equals(operation)) {
                    result = n1 + n2;
                }
                else if ("-".equals(operation)) {
                    result = n1 - n2;
                }
                else if ("*".equals(operation)) {
                    result = n1 * n2;
                }

                super.print(s + Integer.toString(result));
            }
        };

        System.setOut(printStream);


        testString.printSomething();

        String result = outputStream.toString();

        System.setOut(consoleStream);

        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("50 + 16 = ");
        }
    }
}

