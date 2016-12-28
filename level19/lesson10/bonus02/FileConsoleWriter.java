package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileConsoleWriter extends FileWriter
{
    public FileConsoleWriter(String fileName) throws IOException
    {
        super(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException
    {
        super(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException
    {
        super(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException
    {
        super(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd)
    {
        super(fd);
    }

    @Override
    public void write(int c) throws IOException
    {
        System.out.write((char)c);
        System.out.flush();
        super.write(c);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException
    {
        String buff = new String(cbuf);
        String sub = buff.substring(off, (off+len));
        System.out.print(sub);
        super.write(cbuf, off, len);
    }

    @Override
    public void write(String str, int off, int len) throws IOException
    {
        char[] cbuf = new char[len];
        str.getChars(off, (off + len), cbuf, 0);
        write(cbuf, 0, len);
    }

    @Override
    public void write(char[] cbuf) throws IOException
    {
        write(cbuf, 0, cbuf.length);
    }

    @Override
    public void write(String str) throws IOException
    {
        write(str, 0, str.length());
    }

    public static void main(String[] args) throws Exception
    {
        FileConsoleWriter consoleWriter = new FileConsoleWriter("D:/bonus02.txt");

        consoleWriter.write("consoleWriter.write(\"string\")");
        consoleWriter.write('+');
        consoleWriter.write(new char[] {65, 66, 67, 68, 69, 70});
        consoleWriter.write(91);
        consoleWriter.write(new char[] {65, 66, 67, 68, 69, 70}, 2, 2);
        consoleWriter.write("substring except this", 0, 9);

        char tmp[] = {'a','b','c'};
        consoleWriter.write(tmp,1,2);
        consoleWriter.write(tmp);
        consoleWriter.write(116);
        consoleWriter.write("mother",2,2);
        consoleWriter.write("mother");

        consoleWriter.close();
    }
}
