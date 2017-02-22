package com.javarush.test.level26.lesson10.home02;

import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by nemchinov on 21.02.2017.
 */
public class Producer implements Runnable
{
    protected ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map)
    {
        this.map = map;
    }

    @Override
    public void run()
    {
        try {
            Thread currentThread = Thread.currentThread();
            int counter = 0;
            while (!currentThread.isInterrupted())
            {
                counter++;
                map.put(String.valueOf(counter), String.format("Some text for %d", counter));
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }
}
