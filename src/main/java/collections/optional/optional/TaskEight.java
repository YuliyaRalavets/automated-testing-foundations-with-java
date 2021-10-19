package collections.optional.optional;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TaskEight {
    public static void main(String[] args) {
        try (Scanner file = new Scanner(new File("file1.txt")).useDelimiter("[^\\p{L}\\p{Digit}]+"))
        {
            Set<String> words = new HashSet<>();
            while (file.hasNext()) {
                String word = file.next().trim().toLowerCase();
                words.add(word);
            }
            System.out.println(words);
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e);}
    }
}
