package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

public class Restaurant
{
    public static void main(String[] args)
    {
        ConsoleHelper.writeMessage(Dish.allDishesToString());
        new Tablet(5).createOrder();
    }
}
