package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

import static com.javarush.test.level26.lesson15.big01.CashMachine.RESOURCE_PATH;

/**
 * Created by nemchinov on 22.02.2017.
 */
public class ConsoleHelper
{
    private static ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "common");

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException
    {
        String message = "";
        try
        {
            message = reader.readLine();
            if (message.equalsIgnoreCase(res.getString("operation.EXIT")))
            {
                throw new InterruptOperationException();
            }
        }
        catch (IOException e)
        {

        }
        return message;
    }

    public static String askCurrencyCode() throws InterruptOperationException
    {
        String result = "";
        boolean valid = false;

        while (!valid)
        {
            writeMessage(res.getString("choose.currency.code"));
            result = readString();
            valid = result.length() == 3;
            if (!valid)
                writeMessage(res.getString("invalid.data"));
        }
        return result.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
        String[] array;

        while (true)
        {
            writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
            String s = readString();
            array = s.split(" ");
            int k;
            int l;
            try
            {
                k = Integer.parseInt(array[0]);
                l = Integer.parseInt(array[1]);
            }
            catch (NumberFormatException e)
            {
                writeMessage(res.getString("invalid.data"));
                continue;
            }

            if (k <= 0 || l <= 0 || array.length > 2)
            {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            break;
        }
        return array;
    }

    public static Operation askOperation() throws InterruptOperationException
    {
        while (true)
        {
            String operationNumber = readString();
            try
            {
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(operationNumber));
            }
            catch (Exception e)
            {
                writeMessage(res.getString("invalid.data"));
            }
        }
    }

    public static void printExitMessage()
    {
        writeMessage(res.getString("the.end"));
    }
}
