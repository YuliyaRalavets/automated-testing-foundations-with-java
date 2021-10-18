package fundamentals.mainTaskFour;

public class TaskFour {
    public static void main(String[] args) {
        int sum = 0;
        int mult = 1;
        if (args.length >= 2) {
            for (String arg : args) {
                sum += Integer.parseInt(arg.trim());
                mult *= Integer.parseInt(arg.trim());
            }
            System.out.println("Sum is " + sum);
            System.out.println("Multiplication is " + mult);
        } else System.out.println("Should be at least two arguments!");
    }
}
