package com.javarush.test.level26.lesson10.home01;

import java.util.concurrent.BlockingQueue;

/**
 * Created by nemchinov on 21.02.2017.
 */
public class Consumer implements Runnable
{
    protected BlockingQueue queue;

    @Override
    public void run()
    {
        try {
            int i = 0;
            while (true)
            {
                System.out.println((String)queue.take());
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println(String.format("[%s] thread was terminated", Thread.currentThread().getName()));
        }
    }

    public Consumer(BlockingQueue queue)
    {
        this.queue = queue;
    }
}
