package fundamentals.mainTaskFour;

import java.util.Scanner;

public class TaskFour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine;
        int number;
        int sum = 0;
        int multiplication = 1;

        System.out.println("Input at least two integer numbers using space as a delimiter:");
        inputLine = scanner.nextLine();

        String inputLineWithoutSpaces = inputLine.replaceAll(" ", "");
        for (int i = 0; i < inputLineWithoutSpaces.length(); i++) {
            if (!Character.isDigit(inputLineWithoutSpaces.charAt(i)) && inputLineWithoutSpaces.charAt(i) != '-') {
                System.out.println("Incorrect input data!");
                return;
            }
        }

        if (inputLine.length() < 2) {
            System.out.println("Should be at least two numbers!");
        } else {
            String[] massOfNumbers = inputLine.split(" ");
            for (String stringNumber : massOfNumbers) {
                if (stringNumber.contains("-") && stringNumber.indexOf("-") != 0) {
                    System.out.println("Incorrect input data!");
                    return;
                } else {
                    number = Integer.parseInt(stringNumber);
                    sum += number;
                    multiplication *= number;
                }
            }
            System.out.println("The sum is " + sum + "\n" + "The multiplication is " + multiplication);
        }
    }
}
