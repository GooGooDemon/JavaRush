package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;

import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cook extends Observable implements Observer
{
    private String name;
    private static Logger logger = Logger.getLogger(Cook.class.getName());

    public Cook(String name)
    {
        this.name = name;
    }

    public void update(Observable observable, Object arg)
    {
        Order order = (Order) arg;
        ConsoleHelper.writeMessage(String.format("Start cooking - %s, cooking time %dmin", order.toString(), order.getTotalCookingTime()));

        setChanged();
        notifyObservers(order);
    }

    @Override
    public String toString()
    {
        return name;
    }
}
