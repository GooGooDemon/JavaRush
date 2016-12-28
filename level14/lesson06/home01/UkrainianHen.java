package com.javarush.test.level14.lesson06.home01;

/**
 * Created by nemchinov on 21.10.2016.
 */
public class UkrainianHen extends Hen
{

    UkrainianHen(String country)
    {
        super(country);
    }

    int getCountOfEggsPerMonth() {
        return 15;
    }

    public String getDescription() {
        return super.getDescription() + " Моя страна - " + getCountry() + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
