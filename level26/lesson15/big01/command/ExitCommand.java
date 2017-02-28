package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

import static com.javarush.test.level26.lesson15.big01.CashMachine.RESOURCE_PATH;

class ExitCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "exit");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));

        String answer = ConsoleHelper.readString();
        if (res.getString("yes").equalsIgnoreCase(answer))
        {
            ConsoleHelper.writeMessage(res.getString("thank.message"));
        }
    }
}
