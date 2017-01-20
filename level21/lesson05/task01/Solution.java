package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Solution other = (Solution) obj;
        return Objects.equals(first, other.first) &&
                Objects.equals(last, other.last);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(first, last);
    }

    public static void main(String[] args) {
        Set<Solution> set = new HashSet<>();
        System.out.println("must be 4 true");
        System.out.println(new Solution(null, null).equals(new Solution(null, null)));
        System.out.println(new Solution(null, "Duck").equals(new Solution(null, "Duck")));
        System.out.println(new Solution("Donald", null).equals(new Solution("Donald", null)));
        System.out.println(new Solution("Donald", "Duck").equals(new Solution("Donald", "Duck")));

        System.out.println("must be 2 false");
        System.out.println(new Solution(null, "Duck").equals(new Solution("Donald", "Duck")));
        System.out.println(new Solution("Donald", "Duck").equals(new Solution("Donald", null)));

        Solution a = new Solution("Donald", "Duck");
        Solution b = new Solution("Donald", "Duck");
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

        set.add(a);

        System.out.println("must be true: " + a.equals(b));
        System.out.println("must be true: " + set.contains(b));
    }
}
