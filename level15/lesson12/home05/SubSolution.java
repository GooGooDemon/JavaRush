package com.javarush.test.level15.lesson12.home05;

/**
 * Created by nemchinov on 28.10.2016.
 */
public class SubSolution extends Solution
{
    public SubSolution(int x, String s)
    {
        super(x, s);
    }

    public SubSolution(double d, String s)
    {
        super(d, s);
    }

    public SubSolution(Integer num, String s)
    {
        super(num, s);
    }

    protected SubSolution(int x, int y)
    {
        super(x, y);
    }

    protected SubSolution(double x, double y)
    {
        super(x, y);
    }

    protected SubSolution(String s1, String s2)
    {
        super(s1, s2);
    }

    SubSolution()
    {
    }

    SubSolution(String s, int a, int b)
    {
        super(s, a, b);
    }

    SubSolution(String s, double a, double b)
    {
        super(s, a, b);
    }

    private SubSolution(int x) {}
    private SubSolution(double x) {}
    private SubSolution(String s1, int a) {}
}
