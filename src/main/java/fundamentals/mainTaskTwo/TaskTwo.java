package fundamentals.mainTaskTwo;

import java.util.Scanner;

public class TaskTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder in = new StringBuilder(scanner.nextLine());
        if (!(in.length() == 0)){
            System.out.println(in.reverse());
        } else System.out.println("No data for input!");

       /* System.out.print("Reverse: ");
        for (int i = args.length - 1; i >= 0; i--)
            System.out.print(" "+ args[i]);*/
    }
}
