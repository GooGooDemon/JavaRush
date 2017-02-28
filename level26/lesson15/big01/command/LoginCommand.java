package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

import static com.javarush.test.level26.lesson15.big01.CashMachine.RESOURCE_PATH;

/**
 * Created by nemchinov on 27.02.2017.
 */
public class LoginCommand implements Command
{
    private ResourceBundle res = ResourceBundle.getBundle(RESOURCE_PATH + "login");
    private ResourceBundle validCreditCards = ResourceBundle.getBundle(RESOURCE_PATH + "verifiedCards");

    @Override
    public void execute() throws InterruptOperationException
    {
        ConsoleHelper.writeMessage(res.getString("before"));

        boolean valid = false;

        while (!valid)
        {
            ConsoleHelper.writeMessage(res.getString("specify.data"));

            String number = ConsoleHelper.readString();
            if (!number.matches("\\d{12}"))
            {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }

            String pin = ConsoleHelper.readString();
            if (!pin.matches("\\d{4}"))
            {
                ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                continue;
            }

            if (validCreditCards.containsKey(number) && validCreditCards.getString(number).equals(pin))
            {
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), number));
                valid = true;
            }
            else
            {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), number));
            }
        }
    }
}
