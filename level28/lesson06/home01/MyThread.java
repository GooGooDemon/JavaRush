package com.javarush.test.level28.lesson06.home01;


public class MyThread extends Thread
{
    private static int priority = 0;

    public MyThread()
    {
        setPriority();
    }

    public MyThread(Runnable target)
    {
        super(target);
        setPriority();
    }

    public MyThread(String name)
    {
        super(name);
        setPriority();
    }

    public MyThread(Runnable target, String name)
    {
        super(target, name);
        setPriority();
    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);
        setPriority();
    }

    private void setPriority()
    {
        if (++priority > 10) priority = MIN_PRIORITY;
        setPriority(priority);
    }

    @Override
    public void run()
    {
        super.run();
    }
}
