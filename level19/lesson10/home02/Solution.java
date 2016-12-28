package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/
// сделал, но не отправил
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) return;

        String fileName = args[0];

        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

        Map<String, Double> map = new TreeMap<>();
        String line;
        while ((line = fileReader.readLine()) != null) {
            String[] values = line.split(" ");

            String name = values[0];
            Double value = Double.parseDouble(values[1].trim());
            if (map.containsKey(name)) {
                Double oldValue = map.get(name);
                map.put(name, oldValue + value);
            }
            else {
                map.put(name, value);
            }
        }
        fileReader.close();

        double max = Double.MIN_VALUE;
        for (Map.Entry<String, Double> pair : map.entrySet()) {
            if (pair.getValue() > max) max = pair.getValue();
        }

        for (Map.Entry<String, Double> pair : map.entrySet()) {
            if (pair.getValue().equals(max))
                System.out.println(pair.getKey());
        }
    }
}
