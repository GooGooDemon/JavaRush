package com.javarush.test.level20.lesson10.home06;

import java.io.*;

/* Запрет сериализации
Запретите сериализацию класса SubSolution используя NotSerializableException.
Сигнатуры классов менять нельзя
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution
    {
        private void writeObject(java.io.ObjectOutputStream out) throws IOException
        {
            throw new NotSerializableException("Non serializable class!");
        }
        private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException
        {
            throw new NotSerializableException("Non serializable class!");
        }
    }
}
