package fundamentals.mainTaskTwo;

import java.util.Scanner;

public class TaskTwo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder inputLine = new StringBuilder(scanner.nextLine());
        if (!(inputLine.length() == 0)){
            System.out.println(inputLine.reverse());
        } else System.out.println("No data for input!");
    }
}
