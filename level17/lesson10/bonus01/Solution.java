package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        if (args.length == 0) {
            System.out.println("Необходимо указать параметры");
            return;
        }

        String operation = args[0];

        if (operation.equals("-c")) {
            String nameArg = args[1];
            String sexArg = args[2];
            String bdArg = args[3];

            Date bd = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(bdArg);

            Person person = null;

            if ("м".equals(sexArg))
                person = Person.createMale(nameArg, bd);
            else if ("ж".equals(sexArg))
                person = Person.createFemale(nameArg, bd);

            allPeople.add(person);
            System.out.println(allPeople.size()-1);
            return;
        }

        if (operation.equals("-u")) {
            Integer index = Integer.parseInt(args[1]);
            String nameArg = args[2];
            String sexArg = args[3];
            String bdArg = args[4];

            Person person = allPeople.get(index);

            Date bd = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).parse(bdArg);

            Sex sex = Sex.MALE;
            if ("м".equals(sexArg))
                sex = Sex.MALE;
            else if ("ж".equals(sexArg))
                sex = Sex.FEMALE;

            person.setName(nameArg);
            person.setSex(sex);
            person.setBirthDay(bd);
            return;
        }

        if (operation.equals("-d")) {
            int index = Integer.parseInt(args[1]);
            allPeople.remove(index);
            return;
        }

        if (operation.equals("-i")) {
            Integer index = Integer.parseInt(args[1]);
            Person person = allPeople.get(index);
            // name sex (м/ж) bd (формат 15-Apr-1990)

            String sex = person.getSex() == Sex.MALE ? "м" : "ж";
            String bd = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDay());
            System.out.println(person.getName() + " " + sex + " " + bd);
            return;
        }
    }
}
