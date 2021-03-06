package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

import java.util.Collection;
import java.util.ResourceBundle;

import static com.javarush.test.level26.lesson15.big01.CashMachine.RESOURCE_PATH;

class InfoCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "info");

    @Override
    public void execute()
    {
        ConsoleHelper.writeMessage(res.getString("before"));

        boolean hasMoney = false;

        Collection<CurrencyManipulator> manipulators = CurrencyManipulatorFactory.getAllCurrencyManipulators();

        for (CurrencyManipulator manipulator : manipulators)
        {
            if (manipulator.hasMoney())
            {
                ConsoleHelper.writeMessage(String.format("%s - %d", manipulator.getCurrencyCode(), manipulator.getTotalAmount()));
                hasMoney = true;
            }
        }
        if (!hasMoney)
        {
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }
    }
}
