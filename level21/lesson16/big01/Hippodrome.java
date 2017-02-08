package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by nemchinov on 23.01.2017.
 */
public class Hippodrome
{
    public static Hippodrome game;
    private ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++)
        {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    public void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        System.out.println();
        System.out.println();
    }

    public Horse getWinner() {
        Horse winner = null;
        double max = Double.MIN_VALUE;
        for (Horse horse : horses) {
            if (horse.getDistance() > max) {
                max = horse.getDistance();
                winner = horse;
            }
        }
        return winner;
    }

    public void printWinner() {
        System.out.println(String.format("Winner is %s!", getWinner().getName()));
    }

    public static void main(String[] args) throws Exception
    {
        game = new Hippodrome();
        game.getHorses().add(new Horse("Вороной", 3, 0));
        game.getHorses().add(new Horse("Пятнышко", 3, 0));
        game.getHorses().add(new Horse("Ураган", 3, 0));
        game.run();
        game.printWinner();
    }
}
