package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {

    Solution() {}
    Solution(String s, int a, int b) {}
    Solution(String s, double a, double b) {}

    public Solution(int x, String s) {}
    public Solution(double d, String s) {}
    public Solution(Integer num, String s) {}

    protected Solution(int x, int y) {}
    protected Solution(double x, double y) {}
    protected Solution(String s1, String s2) {}

    private Solution(int x) {}
    private Solution(double x) {}
    private Solution(String s1, int a) {}
}

