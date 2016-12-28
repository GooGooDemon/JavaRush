package com.javarush.test.level14.lesson08.home09;

/**
 * Created by nemchinov on 24.10.2016.
 */
public class USD extends Money
{
    USD(double amount)
    {
        super(amount);
    }

    public String getCurrencyName() { return "USD"; }
}
