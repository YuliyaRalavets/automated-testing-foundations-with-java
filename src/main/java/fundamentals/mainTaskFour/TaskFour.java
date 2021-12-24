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
            for (String element : massOfNumbers) {
                if (element.contains("-") && element.indexOf("-") != 0) {
                    System.out.println("Incorrect input data!");
                    return;
                }
            }
            for (String stringNumber : massOfNumbers) {
                number = Integer.parseInt(stringNumber);
                sum += number;
                multiplication *= number;
            }
            System.out.println("The sum is " + sum + "\n" + "The multiplication is " + multiplication);
        }
        /*int sum = 0;
        int mult = 1;
        if (args.length >= 2) {
            for (String arg : args) {
                sum += Integer.parseInt(arg.trim());
                mult *= Integer.parseInt(arg.trim());
            }
            System.out.println("Sum is " + sum);
            System.out.println("Multiplication is " + mult);
        } else System.out.println("Should be at least two arguments!");*/
    }
}
