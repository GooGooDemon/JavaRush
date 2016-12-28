package com.javarush.test.level14.lesson08.home09;

/**
 * Created by nemchinov on 24.10.2016.
 */
public class Hrivna extends Money
{
    Hrivna(double amount)
    {
        super(amount);
    }

    public String getCurrencyName() { return "HRN"; }
}
