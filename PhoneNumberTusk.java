package first.steps.in.Selenium;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class Main {

    public static void main(String[] args) {
        boolean isNumberValid = false;
        System.out.println("Enter the phone number");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        if (number.length() > 10) {
            if (numberContainsOnlyDigits(number) &&
                    numberHasCorrectPrefix(number) && numberHasValidOperatorPrefix(number)) {
                isNumberValid = true;
            }
        }
        if (number.length() == 10) {
            if (numberContainsOnlyDigits(number) && numberHasValidOperatorPrefix(number)) {
                isNumberValid = true;
            }
        }
        while (!isNumberValid) {
            System.out.println("Phone number is incorrect.");
            System.out.println("Enter the phone number");
            number = scanner.nextLine();
            while (number.length() < 10) {
                System.out.println("Phone number is incorrect.");
                System.out.println("Enter the phone number");
                number = scanner.nextLine();
            }
            if (number.length() > 10) {
                if (numberContainsOnlyDigits(number) &&
                        numberHasCorrectPrefix(number) && numberHasValidOperatorPrefix(number)) {
                    isNumberValid = true;
                }
            }
            if (number.length() == 10) {
                if (numberContainsOnlyDigits(number) && numberHasValidOperatorPrefix(number)) {
                    isNumberValid = true;
                }
            }
        }
        System.out.println("Phone number is correct.");
        System.out.println("________________________________________");
        char[] numbers = number.toCharArray();
        if(number.startsWith("+")){
            number=number.substring(number.length()-10,number.length());
        }
        long valueOfNumber = Long.parseLong(number);
        long sumOfDigits = sumOfNumbers(valueOfNumber);
        int roundOfCalculation = 1;
        System.out.println("1st round of calculation: " + sumOfDigits);
        while (sumOfDigits > 9) {
            sumOfDigits = sumOfNumbers(sumOfDigits);
            roundOfCalculation++;
            System.out.println(roundOfCalculation + "st round of calculation: " + sumOfDigits);
        }
        if (sumOfDigits > 4) {
            System.out.println("Final result is: " + sumOfDigits);
        } else {
            switch ((int)sumOfDigits) {
                case (1):
                    System.out.println("Final result is: One");
                    break;
                case (2):
                    System.out.println("Final result is: Two");
                    break;
                case (3):
                    System.out.println("Final result is: Three");
                    break;
                case (4):
                    System.out.println("Final result is: Four");
                    break;
            }
        }
    }

    public static boolean numberContainsOnlyDigits(String string) {
        char[] numbers = string.toCharArray();
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            String numberValue = String.valueOf(numbers[i]);
            strNumbers[i] = numberValue;
        }
        if (strNumbers[0].equals("+")) {
            for (int i = 0; i < strNumbers.length - 1; i++) {
                if (strNumbers[i + 1].matches("\\D")) {
                    return false;
                }
            }
        }
        if (!strNumbers[0].equals("+")) {
            for (String strNumber : strNumbers) {
                if (strNumber.matches("\\D")) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean numberHasCorrectPrefix(String string) {
        String correctPrefix1 = "+38";
        String correctPrefix2 = "38";
        String correctPrefix3 = "0038";
        String correctPrefix4 = "8";
        return string.startsWith(correctPrefix1) || string.startsWith(correctPrefix2) ||
                string.startsWith(correctPrefix3) || string.startsWith(correctPrefix4);
    }

    public static boolean numberHasValidOperatorPrefix(String string) {
        String lastFourDigitsOfNumber = string.substring(string.length() - 10, string.length());
        String lifePrefix = "093";
        String vodafonePrefix = "050";
        String kyivstarPrefix = "067";
        return lastFourDigitsOfNumber.startsWith(lifePrefix) || lastFourDigitsOfNumber.startsWith(vodafonePrefix) ||
                lastFourDigitsOfNumber.startsWith(kyivstarPrefix);
    }

    public static long sumOfNumbers(long valueOfNumber) {
        long sumOfDigits = 0;
        while (valueOfNumber > 0) {
            sumOfDigits = sumOfDigits + valueOfNumber % 10;
            valueOfNumber = valueOfNumber / 10;
        }
        return sumOfDigits;
    }
}
