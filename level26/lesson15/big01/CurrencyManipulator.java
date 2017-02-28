package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by nemchinov on 22.02.2017.
 */
public class CurrencyManipulator
{
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }

    public void addAmount(int denomination, int count)
    {
        if (denominations.containsKey(denomination))
        {
            denominations.put(denomination, denominations.get(denomination) + count);
        }
        else
        {
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount()
    {
        int total = 0;
        for (Map.Entry<Integer, Integer> entry : denominations.entrySet())
        {
            total += entry.getKey() * entry.getValue();
        }
        return total;
    }

    public boolean hasMoney()
    {
        return denominations.size() > 0;
    }

    public boolean isAmountAvailable(int expectedAmount)
    {
        return getTotalAmount() >= expectedAmount;
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        Map<Integer, Integer> result = new TreeMap<>(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2.compareTo(o1);
            }
        });

        ArrayList<Integer> nominals =  new ArrayList<>(denominations.keySet());
        Collections.sort(nominals, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o2.compareTo(o1);
            }
        });

        // сумма к выдаче 600
        int amountToWithdraw = expectedAmount;

        for (Integer nominal : nominals)
        {
            // имеющееся количество банкнот этого номинала в банкомате
            Integer countDenominations = denominations.get(nominal);

            // сколько банкнот можно запросить
            // 600 / 500  = 1
            int count = amountToWithdraw / nominal;
            if (count > 0 && countDenominations > 0)
            {
                // больше чем имеется выдать не можем
                if (count > countDenominations) count = countDenominations;

                result.put(nominal, count);
                amountToWithdraw -= nominal * count; // 600 - 500 * 1 = 100
            }

            if (amountToWithdraw == 0)
            {
                break;
            }
        }

        if (amountToWithdraw > 0) throw new NotEnoughMoneyException();


        for (Map.Entry<Integer, Integer> entry : result.entrySet())
        {
            int nominal = entry.getKey();
            int count = entry.getValue();
            denominations.put(nominal, denominations.get(nominal) - count);
        }

        return result;
    }
}
