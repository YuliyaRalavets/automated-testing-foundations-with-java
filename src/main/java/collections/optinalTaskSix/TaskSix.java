package collections.optinalTaskSix;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TaskSix {
    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        try (Scanner file = new Scanner(new File("file1.txt"))) {
            while (file.hasNext()) {
                String line = file.nextLine();
                if (!line.isEmpty()) {
                    myList.add(line);
                }
            }
            Collections.sort(myList);
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e);
        }
    }
}
