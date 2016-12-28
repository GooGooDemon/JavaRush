package com.javarush.test.level14.lesson06.home01;

/**
 * Created by nemchinov on 21.10.2016.
 */
public class MoldovanHen extends Hen
{
    MoldovanHen(String country)
    {
        super(country);
    }

    int getCountOfEggsPerMonth() {
        return 12;
    }

    public String getDescription() {
        return super.getDescription() + " Моя страна - " + getCountry() + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}
