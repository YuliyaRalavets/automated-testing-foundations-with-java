package fundamentals.mainTaskOne;

import java.util.Scanner;

public class TaskOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        if (!(name.length() == 0))
            System.out.println("Hello " + name + "!");
        else System.out.println("No input name!");
        //if(args.length > 0) {
        //    System.out.println("Hello, " + args[0] + "!");
        //}
    }
}
