package com.javarush.test.level17.lesson06.task02;

/* Предложения
Не используя synchronized сделайте так, чтобы количество сделанных и принятых предложений было одинаковым.
*/
// Решено, но не проверено

public class Solution {
    public static volatile int proposal = 0;

    public static void main(String[] args) {
        new MakeProposal().start();
        new AcceptProposal().start();
    }

    public static class MakeProposal extends Thread {
        @Override
        public void run() {
            while (proposal < 100) {
                System.out.println("Сделано предложение №" + proposal);
                proposal++;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class AcceptProposal extends Thread {
        @Override
        public void run() {
            while (proposal < 100) {
                System.out.println("Принято предложение №" + proposal);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
