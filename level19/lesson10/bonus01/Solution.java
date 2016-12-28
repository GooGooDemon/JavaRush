package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
строка0                           ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка5                           ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws Exception {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = console.readLine();
        String fileName2 = console.readLine();
        console.close();

        BufferedReader file1 = new BufferedReader(new FileReader(fileName1));
        BufferedReader file2 = new BufferedReader(new FileReader(fileName2));

        String line;
        ArrayList<String> list1 = new ArrayList<>();
        while ((line = file1.readLine()) != null) {
            list1.add(line);
        }

        ArrayList<String> list2 = new ArrayList<>();
        while ((line = file2.readLine()) != null) {
            list2.add(line);
        }

        String str1;
        String str2;
        int index1 = 0;
        int index2 = 0;

        while (index1 < list1.size() || index2 < list2.size()) {
            if (index1 < list1.size()) str1 = list1.get(index1); else str1 = null;
            if (index2 < list2.size()) str2 = list2.get(index2); else str2 = null;

            if (str1 != null && str2 != null) {
                if (str1.equals(str2) && str2.length() > 0) {
                    lines.add(new LineItem(Type.SAME, str1));
                    index1++;
                    index2++;
                    continue;
                }
                if (!str1.equals(str2))
                {
                    if (str2.length() > 0 && !list1.contains(str2)) {
                        lines.add(new LineItem(Type.ADDED, str2));
                        index2++;
                    }
                    else
                    {
                        lines.add(new LineItem(Type.REMOVED, str1));
                        index1++;
                    }
                }
            }
            else if (str1 == null) {
                lines.add(new LineItem(Type.ADDED, str2));
                index2++;
            }
            else { // if (str2 == null)
                lines.add(new LineItem(Type.ADDED, str1));
                index1++;
            }
        }


        for (LineItem item : lines) {
            System.out.println(item.type + " " + item.line);
        }

        file1.close();
        file2.close();
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
