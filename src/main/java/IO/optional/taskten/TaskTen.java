package IO.optional.taskten;

import IO.optional.CreatorDirAndFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TaskTen {
    public static void main(String[] args) {
        String dirName = "Task ten";
        CreatorDirAndFile creatorDirAndFile = new CreatorDirAndFile(dirName);
        String lineFromFile;
        List<String> list = new ArrayList<>();
        try(BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("file for ten task.txt"))){
            do{
                lineFromFile = bufferedReader.readLine();
                if (lineFromFile != null){
                    list.add(swapWords(lineFromFile));
                }
            } while (lineFromFile != null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        creatorDirAndFile.writeToFile(list);
    }

    private static String swapWords(String line) {
        String[] massOfNumbers = line.split(" ");
        String temp = massOfNumbers[0];
        massOfNumbers[0] = massOfNumbers[massOfNumbers.length - 1];
        massOfNumbers[massOfNumbers.length - 1] = temp;
        return String.join(" ", massOfNumbers);
    }
}
