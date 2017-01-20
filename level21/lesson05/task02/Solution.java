package com.javarush.test.level21.lesson05.task02;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* Исправить ошибку
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Solution n = (Solution) obj;
        return Objects.equals(first, n.first) && Objects.equals(last, n.last);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(first, last);
    }

    public static void main(String[] args) {
        Set<Solution> set = new HashSet<>();
        Solution a = new Solution("Mickey", "Mouse");
        Solution b = new Solution("Mickey", "Mouse");
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

        set.add(a);
        set.add(new Solution("Mickey", "Mouse"));

        System.out.println(a.equals(b));
        System.out.println(a.hashCode() == b.hashCode());
        System.out.println(set.contains(new Solution("Mickey", "Mouse")));
    }
}
