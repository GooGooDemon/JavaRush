package com.javarush.test.level27.lesson09.home01;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() {
        try
        {
            // Ждём когда ProducerTask обновит value и установит флаг isValuePresent в true
            while (!isValuePresent)
            {
                wait();
            }
        }
        catch (InterruptedException e)
        {

        }
        System.out.println("Got: " + value);
        isValuePresent = false;
        notify();
        return value;
    }

    public synchronized void put(int value) {
        try
        {
            // Ждём когда ConsumerTask получит value и установит флаг isValuePresent в false
            while (isValuePresent)
            {
                wait();
            }
        }
        catch (InterruptedException e)
        {

        }
        this.value = value;
        isValuePresent = true;
        notify();
        System.out.println("Put: " + value);
    }
}
