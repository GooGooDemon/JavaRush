package com.javarush.test.level20.lesson10.home09;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* Знакомство с графами
Прочитать в дополнительных материалах о сериализации графов.
Дан ориентированный плоский граф Solution, содержащий циклы и петли.
Пример, http://edu.nstu.ru/courses/saod/images/graph1.gif
Сериализовать Solution.
Все данные должны сохранить порядок следования.
*/
public class Solution implements Externalizable
{
    int node;
    List<Solution> edges = new LinkedList<>();

    @Override
    public void writeExternal(ObjectOutput out) throws IOException
    {
        out.writeInt(node);
        out.writeInt(edges.size());
        for (Solution item : edges) {
            out.writeObject(item);
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        node = in.readInt();
        int count = in.readInt();
        for (int i = 0; i < count; i++)
        {
            edges.add((Solution)in.readObject());
        }
    }
}
