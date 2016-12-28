package com.javarush.test.level03.lesson05.task03;

/* Конвертер времени
Добавьте метод public static int convertToSeconds(int hour) который будет конвертировать часы в секунды.
Вызовите его дважды в методе main с любыми параметрами. Результаты выведите на экран, каждый раз с новой строки.
*/

public class Solution
{

    //напишите тут ваш код

    public static void main(String[] args) {
        //напишите тут ваш код
        int seconds = convertToSeconds(5);
        System.out.println(seconds);

        seconds = convertToSeconds(7);
        System.out.println(seconds);
    }

    public static int convertToSeconds(int hour)
    {
        return hour * 60 * 60;
    }
}