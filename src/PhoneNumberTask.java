import java.util.Scanner;


public class PhoneNumberTask {

    public static void main(String[] args) {
        boolean isNumberValid = false;
        System.out.println("Enter the phone number");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        if (number.length() > 10) {
            if (number.substring(0, number.length() - 10).matches("(38|8|\\D38|0038)") &&
                    number.substring(number.length() - 10, number.length())
                            .matches("(067\\d{7}|093\\d{7}|050\\d{7})")) {
                isNumberValid = true;
            }
        }
        if (number.length() == 10) {
            if (number.matches("(067\\d{7}|093\\d{7}|050\\d{7})")) {
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
                if (number.substring(0, number.length() - 10).matches("(38|8|\\D38|0038)")
                        && number.substring(number.length() - 10, number.length())
                        .matches("(067\\d{7}|093\\d{7}|050\\d{7})")) {
                    isNumberValid = true;
                }
            }
            if (number.length() == 10) {
                if (number.matches("(067\\d{7}|093\\d{7}|050\\d{7})")) {
                    isNumberValid = true;
                }
            }
        }
        System.out.println("Phone number is correct.");
        System.out.println("________________________________________");
        if (number.startsWith("+")) {
            number = number.substring(number.length() - (number.length() - 1), number.length());
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
            switch ((int) sumOfDigits) {
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

    public static long sumOfNumbers(long valueOfNumber) {
        long sumOfDigits = 0;
        while (valueOfNumber > 0) {
            sumOfDigits = sumOfDigits + valueOfNumber % 10;
            valueOfNumber = valueOfNumber / 10;
        }
        return sumOfDigits;
    }
}
