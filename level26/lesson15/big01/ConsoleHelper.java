package com.javarush.test.level26.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by nemchinov on 22.02.2017.
 */
public class ConsoleHelper
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString()
    {
        String message = "";
        try
        {
            return reader.readLine();
        }
        catch (IOException e)
        {

        }
        return message;
    }

    public static String askCurrencyCode()
    {
        String result = "";
        boolean valid = false;

        while (!valid)
        {
            writeMessage("Enter currency code (3 symbols):");
            result = readString();
            valid = result.length() == 3;
            if (!valid)
                writeMessage("Invalid currency code! Enter again, please...");
        }
        return result.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode)
    {
        String[] array;

        while (true)
        {
            writeMessage("Enter nominal and count (two positive numbers greater than zero):");
            String s = readString();
            array = s.split(" ");
            int k;
            int l;
            try
            {
                k = Integer.parseInt(array[0]);
                l = Integer.parseInt(array[1]);
            }
            catch (Exception e)
            {
                writeMessage("Invalid data! Enter again, please...");
                continue;
            }
            if (k <= 0 || l <= 0 || array.length > 2)
            {
                writeMessage("Invalid data! Enter again, please...");
                continue;
            }
            break;
        }
        return array;
    }

    public static Operation askOperation()
    {
        Operation operation = null;
        boolean valid = false;

        while (!valid)
        {
            writeMessage("Enter operation (1 - INFO, 2 - DEPOSIT, 3 - WITHDRAW, 4 - EXIT): ");
            String operationNumber = readString();
            try
            {
                operation = Operation.getAllowableOperationByOrdinal(Integer.parseInt(operationNumber));
            }
            catch (Exception e)
            {

            }
            valid = operation != null;
            if (!valid)
                writeMessage("Invalid operation number! Enter again, please...");
        }
        return operation;
    }
}
