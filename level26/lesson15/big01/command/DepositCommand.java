package com.javarush.test.level26.lesson15.big01.command;


import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

class DepositCommand implements Command
{
    @Override
    public void execute()
    {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        String[] money = ConsoleHelper.getValidTwoDigits(currencyCode);
        manipulator.addAmount(Integer.parseInt(money[0]), Integer.parseInt(money[1]));
    }
}
