package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Map;
import java.util.ResourceBundle;

import static com.javarush.test.level26.lesson15.big01.CashMachine.RESOURCE_PATH;

class WithdrawCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "withdraw");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));

        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);

        boolean success = false;
        while (!success)
        {
            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            int amount = Integer.parseInt(ConsoleHelper.readString());
            if (amount <= 0)
            {
                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                continue;
            }
            if (!manipulator.isAmountAvailable(amount))
            {
                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                continue;
            }

            try
            {
                Map<Integer, Integer> cash = manipulator.withdrawAmount(amount);
                if (cash != null)
                {
                    for (Map.Entry<Integer, Integer> entry : cash.entrySet())
                    {
                        ConsoleHelper.writeMessage(String.format("\t%d - %d", entry.getKey(), entry.getValue()));
                    }
                    success = true;
                }
                else
                    throw new NotEnoughMoneyException();
            }
            catch (NotEnoughMoneyException e)
            {
                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                continue;
            }

            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), amount, currencyCode));
        }
    }
}
