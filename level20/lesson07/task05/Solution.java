package com.javarush.test.level20.lesson07.task05;

import java.io.*;
import java.util.Date;

import static java.lang.Thread.sleep;

/* Переопределение сериализации
Сделайте так, чтобы после десериализации нить runner продолжила работать.
Ключевые слова объекта runner менять нельзя.
Hint/Подсказка:
Конструктор не вызывается при сериализации, только инициализируются все поля.
*/
public class Solution implements Serializable, Runnable {
    transient private Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, does not matter
        while (!runner.isInterrupted())
        {
            System.out.println(runner + " Нить работает! " + new Date().toString());
            try
            {
                sleep(500);
            }
            catch (InterruptedException e) {
                break;
            }
        }
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        runner = new Thread(this);
        runner.start();
    }

    public static void main(String[] args) throws Exception
    {
        Solution solution = new Solution(10);

        sleep(5000);

        File file = File.createTempFile("level20.lesson07.task05.", "");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(solution);
        oos.close();
        fos.close();

        solution.runner.interrupt();
        System.out.println("Засериализовали!");

        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Solution loadedObject = (Solution) ois.readObject();
        System.out.println(loadedObject);
        ois.close();
        fis.close();

        System.out.println("Десериализовали!");

        sleep(5000);

        loadedObject.runner.interrupt();
    }
}
