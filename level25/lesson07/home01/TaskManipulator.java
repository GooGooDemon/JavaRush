package com.javarush.test.level25.lesson07.home01;

import sun.java2d.loops.GraphicsPrimitive;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;

    @Override
    public void start(String threadName)
    {
        thread = new Thread(this, threadName);
        thread.start();
    }

    @Override
    public void stop()
    {
        thread.interrupt();
    }

    @Override
    public void run()
    {
        try
        {
            Thread.sleep(0);
            while (!thread.isInterrupted())
            {
                System.out.println(thread.getName());
                Thread.sleep(90);
            }
        }
        catch (InterruptedException e)
        {

        }
    }
}
