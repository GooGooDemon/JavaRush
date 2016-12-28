package com.javarush.test.level14.lesson06.home01;

/**
 * Created by nemchinov on 21.10.2016.
 */
public abstract class Hen {
    private String country;

    Hen(String country)
    {
        this.country = country;
    }

    public String getCountry() { return country; };

    abstract int getCountOfEggsPerMonth();

    public String getDescription() {
        return "Я курица.";
    }
}
