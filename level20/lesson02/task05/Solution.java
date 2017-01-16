package com.javarush.test.level20.lesson02.task05;

import java.io.*;

/* И еще раз о синхронизации
Разберитесь почему не работает метод main()
Реализуйте логику записи в файл и чтения из файла для класса Object
Метод load должен инициализировать объект данными из файла
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(java.lang.String[] args)
    {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("d:\\level20.lesson02.task05.txt");
            InputStream inputStream = new FileInputStream("d:\\level20.lesson02.task05.txt");

            Object object = new Object();
            object.string1 = new String();   //string #1
            object.string2 = new String();   //string #2
            object.save(outputStream);
            outputStream.flush();

            Object loadedObject = new Object();
            loadedObject.string1 = new String(); //string #3
            loadedObject.string2 = new String(); //string #4

            loadedObject.load(inputStream);

            //check here that the object variable equals to loadedObject - проверьте тут, что object и loadedObject равны
            if (object.equals(loadedObject))
                System.out.println("Равны!");
            else
                System.out.println("Не равны!");

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }


    public static class Object {
        public String string1;
        public String string2;

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            writer.println(string1.number);
            writer.println(string2.number);
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            synchronized (Solution.class)
            {
                int value = Solution.countStrings;
                countStrings = Integer.parseInt(reader.readLine()) - 1;
                string1 = new String();
                countStrings = Integer.parseInt(reader.readLine()) - 1;
                string2 = new String();
                Solution.countStrings = value;
            }
        }

        @Override
        public boolean equals(java.lang.Object obj)
        {
            if (obj == null || getClass() != obj.getClass()) return false;

            Object other = (Object) obj;

            return string1.equals(other.string1) && string2.equals(other.string2);
        }
    }

    public static int countStrings;

    public static class String {
        private final int number;

        public String() {
            number = ++countStrings;
        }

        public void print() {
            System.out.println("string #" + number);
        }

        @Override
        public boolean equals(java.lang.Object obj)
        {
            if (obj == null || getClass() != obj.getClass()) return false;

            String other = (String) obj;

            PrintStream systemPrintStream = System.out;
            java.lang.String myString, otherString;
            try {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                PrintStream myPrintStream = new PrintStream(outputStream);
                System.setOut(myPrintStream);
                print();
                myString = outputStream.toString();
                outputStream.reset();
                other.print();
                otherString = outputStream.toString();
            }
            finally
            {
                System.setOut(systemPrintStream);
            }

            if (myString != null && otherString != null)
                return myString.equals(otherString);
            else
                return false;
        }
    }
}
