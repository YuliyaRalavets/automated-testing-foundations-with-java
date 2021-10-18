package fundamentals.mainTaskTwo;

public class TaskTwo {
    public static void main(String[] args) {
        System.out.print("Reverse: ");
        for (int i = args.length - 1; i >= 0; i--)
            System.out.print(" "+ args[i]);
    }
}
