package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;


public class Producer implements Runnable
{
    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue)
    {
        this.queue = queue;
    }

    @Override
    public void run()
    {
        try
        {
            for (int i = 1; i < 10; i++)
            {
                if (Thread.currentThread().isInterrupted()) return;

                System.out.format("Элемент 'ShareItem-%d' добавлен%n", i);
                ShareItem item = new ShareItem("ShareItem-" + i, i);
                queue.offer(item);

                Thread.sleep(100);

                if (queue.hasWaitingConsumer())
                {
                    System.out.println("Consumer в ожидании!");
                }
            }
        }
        catch (InterruptedException e)
        {
        }
    }
}
