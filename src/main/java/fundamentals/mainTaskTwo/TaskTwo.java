package fundamentals.mainTaskTwo;

import java.util.Scanner;

public class TaskTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input at least two arguments using space as a delimiter:");
        String s = scanner.nextLine();
        String[] mass = s.split(" ");
        if (mass.length < 2)
            System.out.println("Should be at least two arguments!");
        else {
            for (int i = mass.length - 1; i >= 0; i--) {
                System.out.print(mass[i] + " ");
            }
        }
    }
}
