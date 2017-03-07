package com.javarush.test.level27.lesson15.big01.kitchen;

/**
 * Created by nemchinov on 02.03.2017.
 */
public enum Dish
{
    Fish(25),
    Steak(30),
    Soup(15),
    Juice(5),
    Water(3);

    private int duration;

    Dish(int duration)
    {
        this.duration = duration;
    }

    public int getDuration()
    {
        return duration;
    }

    public static String allDishesToString()
    {
        StringBuilder dishes = new StringBuilder();
        for (Dish dish : values())
        {
            dishes.append(dish.toString()).append(", ");
        }
        dishes.delete(dishes.length()-2, dishes.length());
        return dishes.toString();
    }

}
