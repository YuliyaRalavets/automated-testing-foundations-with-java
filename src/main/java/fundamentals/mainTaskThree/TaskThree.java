package fundamentals.mainTaskThree;

import java.util.Random;
import java.util.Scanner;

public class TaskThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numberOfRandomVal;
        System.out.println("Input the number of random values");
        if (scanner.hasNextInt()) {
            numberOfRandomVal = scanner.nextInt();
            if (numberOfRandomVal > 0) {
                System.out.println("Numbers with enter:");
                int number;
                for (int i = 0; i < numberOfRandomVal; i++) {
                    number = random.nextInt();
                    System.out.println(number);
                }
                System.out.println("\nNumbers without enter:");
                for (int i = 0; i < numberOfRandomVal; i++) {
                    number = random.nextInt();
                    System.out.print(number + " ");
                }
            } else System.out.println("Incorrect data!");
        } else System.out.println("Incorrect data!");
    }
}
