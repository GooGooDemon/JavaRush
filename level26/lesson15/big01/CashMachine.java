package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.command.CommandExecutor;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.Locale;
import java.util.ResourceBundle;

public class CashMachine
{
    public static final String RESOURCE_PATH = "com.javarush.test.level26.lesson15.big01.resources.";

    public static void main(String[] args)
    {
        //Locale.setDefault(Locale.ENGLISH);
        Locale.setDefault(new Locale("ru", "RU"));

        ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "common");

        try
        {
            CommandExecutor.execute(Operation.LOGIN);

            Operation operation = null;

            while (Operation.EXIT != operation)
            {
                ConsoleHelper.writeMessage(res.getString("choose.operation"));
                ConsoleHelper.writeMessage(String.format("(1 - %s, 2 - %s, 3 - %s, 4 - %s)",
                        res.getString("operation.INFO"),
                        res.getString("operation.DEPOSIT"),
                        res.getString("operation.WITHDRAW"),
                        res.getString("operation.EXIT")));

                operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
            }
            ConsoleHelper.printExitMessage();
        }
        catch (InterruptOperationException e)
        {

        }
    }
}
