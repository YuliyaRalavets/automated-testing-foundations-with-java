package IO.optional.taskthree;

import IO.optional.CreatorDirAndFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TaskThree {
    public static void main(String[] args) {
        String dirName = "Task three";
        CreatorDirAndFile creatorDirAndFile = new CreatorDirAndFile(dirName);
        String lineFromFile;
        List<String> list = new ArrayList<>();
        try(BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("src/main/java/IO/optional/taskthree/TaskThree.java"))){
            do{
                lineFromFile = bufferedReader.readLine();
                if (lineFromFile != null)
                    list.add(new StringBuffer((lineFromFile)).reverse().toString());
            } while (lineFromFile != null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        creatorDirAndFile.writeToFile(list);
    }
}
