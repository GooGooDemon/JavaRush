package com.javarush.test.level30.lesson02.home01;

import java.math.BigInteger;

import static com.javarush.test.level30.lesson02.home01.NumerationSystemType.*;

/* Конвертер систем счислений
Реализуйте логику метода convertNumberToOtherNumerationSystem, который должен переводить число number.getDigit()
из одной системы счисления(numerationSystem) в другую (expectedNumerationSystem)
бросьте NumberFormatException, если переданное число некорректно, например, число "120" с системой счисления 2
Валидация для - number.getDigit() - целое не отрицательное
Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumerationSystemType._10, "6");
        Number result = convertNumberToOtherNumerationSystem(number, _2);
        System.out.println(result);    //expected 110

        // exceptions expected
        //System.out.println(convertNumberToOtherNumerationSystem(new Number(NumerationSystemType._10, "-120"), _2));
        //System.out.println(convertNumberToOtherNumerationSystem(new Number(NumerationSystemType._10, "12.0"), _2));
        //System.out.println(convertNumberToOtherNumerationSystem(new Number(NumerationSystemType._2, "120"), _10));
        Number number1 = new Number(NumerationSystemType._2, "1101001000000001100001001110110111111100110010101000100111011011011001001011001100011001100000111101111");
        System.out.println(convertNumberToOtherNumerationSystem(number1, _3));
        System.out.println(convertNumberToOtherNumerationSystem(number1, _8));
        System.out.println(convertNumberToOtherNumerationSystem(number1, _10)); //expected 519949509846173492335554907166
        System.out.println(convertNumberToOtherNumerationSystem(number1, _16));

        number = new Number(NumerationSystemType._10, "519949509846173492335554907166");
        result = convertNumberToOtherNumerationSystem(number, NumerationSystemType._2);
        System.out.println(result);    //expected 110100100000000110000100111011011111110011001010100010011101101101100100101100110001100110000011110

    }

    public static Number convertNumberToOtherNumerationSystem(Number number, NumerationSystem expectedNumerationSystem) {
        if (!number.getDigit().matches("\\d*[a-fA-F]*"))
        {
            throw new NumberFormatException();
        }

        BigInteger bigInteger = new BigInteger(number.getDigit(), number.getNumerationSystem().getNumerationSystemIntValue());
        String expectedValue = bigInteger.toString(expectedNumerationSystem.getNumerationSystemIntValue());

        return new Number(expectedNumerationSystem, expectedValue);
    }


}
