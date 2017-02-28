package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

import static com.javarush.test.level26.lesson15.big01.CashMachine.RESOURCE_PATH;

class DepositCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "deposit");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));

        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        String[] money = ConsoleHelper.getValidTwoDigits(currencyCode);
        try
        {
            int nominal = Integer.parseInt(money[0]);
            int count = Integer.parseInt(money[1]);
            manipulator.addAmount(nominal, count);

            int amount = nominal * count;
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), amount, currencyCode));
        }
        catch (NumberFormatException e)
        {
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }

    }
}
