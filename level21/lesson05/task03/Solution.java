package com.javarush.test.level21.lesson05.task03;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/* Ошибка в equals/hashCode
Исправьте ошибки реализаций методов equals и hashCode для класса Solution
*/
public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Solution))
        {
            return false;
        }

        Solution other = (Solution) obj;

        if (anInt != other.anInt) return false;
        if (!Objects.equals(string, other.string)) return false;
        if (Double.compare(other.aDouble, aDouble) != 0) return false;
        if (!Objects.equals(date, other.date)) return false;
        return Objects.equals(solution, other.solution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(anInt, string, aDouble, date, solution);
    }

    public static void main(String[] args) throws Exception
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse("1995-02-23");
        Solution s1 = new Solution(1, "string", 2.5, date1, null);

        Date date2 = sdf.parse("2016-08-15");
        Solution s2 = new Solution(1, "string", 2.5, date2, s1);
        Solution s3 = new Solution(1, "string", 2.5, date2, s1);

        System.out.println(s1.equals(s2));
        System.out.println(s2.equals(s3));
    }
}
