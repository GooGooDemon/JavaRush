package com.javarush.test.level22.lesson13.task02;

import java.io.*;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        if (args.length < 2) return;

        String srcFileName = args[0];
        String dstFileName = args[1];

        try (BufferedReader reader = new BufferedReader(new FileReader(srcFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(dstFileName)))
        {
            String line;
            while ((line = reader.readLine()) != null) {
                byte[] bytes = line.getBytes("Windows-1251");
                String utf = new String(bytes, "UTF-8");
                writer.write(utf);
                if (reader.ready())
                {
                    writer.write("\n");
                }
            }
        }
    }

}
