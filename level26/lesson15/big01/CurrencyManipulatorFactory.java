package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nemchinov on 22.02.2017.
 */
public class CurrencyManipulatorFactory
{
    private static Map<String, CurrencyManipulator> manipulators = new HashMap<>();

    static {
        CurrencyManipulator rub = getManipulatorByCurrencyCode("RUB");
        rub.addAmount(1000, 1);
        rub.addAmount(500, 2);
        rub.addAmount(200, 3);
        rub.addAmount(100, 0);
        rub.addAmount(50, 0);
        //rub.addAmount(50, 100);

        CurrencyManipulator usd = getManipulatorByCurrencyCode("USD");
        usd.addAmount(100, 100);
        usd.addAmount(50, 100);
        usd.addAmount(20, 100);
        usd.addAmount(10, 100);
        usd.addAmount(5, 100);
        usd.addAmount(1, 100);
    }

    private CurrencyManipulatorFactory()
    {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode)
    {
        if (manipulators.containsKey(currencyCode))
        {
            return manipulators.get(currencyCode);
        }
        else
        {
            CurrencyManipulator manipulator = new CurrencyManipulator(currencyCode);
            manipulators.put(currencyCode, manipulator);
            return manipulator;
        }
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators()
    {
        return manipulators.values();
    }
}
