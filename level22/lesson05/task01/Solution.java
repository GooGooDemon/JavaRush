package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static String getPartOfString(String string) throws Exception {
        if (string == null || string.length() < 5) throw new TooShortStringException();

        int posFirst = string.indexOf(' '); // ищем первый пробел
        if (posFirst < 0) throw new TooShortStringException(); // если в строке совсем нет пробелов - выкидываем исключение

        int posFourth = posFirst;
        for (int i = 0; i < 4; i++)
        {
            posFourth = string.indexOf(' ', posFourth+1);
            if (posFourth < 0)  throw new TooShortStringException();
        }
        return string.substring(posFirst+1, posFourth);
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws Exception
    {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));

        String s;

        //1
        s = getPartOfString("  a b c d ");
        System.out.println(s + "|");
        System.out.println("0123456789012345678901234567890");
//2
        s = getPartOfString("JavaRush - лучший сервис            обучения Java.");
        System.out.println(s + "|");
        System.out.println("0123456789012345678901234567890");
//3
        s = getPartOfString("     5");
        System.out.println(s + "|");
        System.out.println("0123456789012345678901234567890");
//4
        s = getPartOfString("  1 + 2= 3");
        System.out.println(s + "|");
        System.out.println("0123456789012345678901234567890");
//5
        s = getPartOfString("a + b = c ");
        System.out.println(s + "|");
        System.out.println("0123456789012345678901234567890");
//6
        s = getPartOfString("    ");
        System.out.println(s + "|");
        System.out.println("0123456789012345678901234567890");
//7
        s = getPartOfString("");
        System.out.println(s + "|");
        System.out.println("0123456789012345678901234567890");
//8
        s = getPartOfString(null);
        System.out.println(s + "|");
        System.out.println("0123456789012345678901234567890");


    }
}
