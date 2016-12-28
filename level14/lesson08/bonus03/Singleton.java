package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by nemchinov on 25.10.2016.
 */
public class Singleton
{
    private Singleton() { }

    public static Singleton getInstance() {
        if (singleton == null)
            singleton = new Singleton();
        return singleton;
    }

    private static Singleton singleton;
}
