package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/
// сделал, но не отправил
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Locale;
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

        for (Map.Entry<String, Double> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }
}
