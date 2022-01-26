package IO.optional.tasktwo;

import IO.optional.CreatorDirAndFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TaskTwo {
    public static void main(String[] args) {
        String dirName = "Task two";
        CreatorDirAndFile creatorDirAndFile = new CreatorDirAndFile(dirName);
        String lineFromFile;
        List<String> list = new ArrayList<>();
        try(BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("D:\\YULIYA\\QA\\EPAM\\automated-testing-foundations-with-java\\src\\main\\java\\IO\\optional\\tasktwo\\TaskTwo.java"))){
            do{
                lineFromFile = bufferedReader.readLine();
                if (lineFromFile != null)
                    list.add(lineFromFile.replace("public","private"));
            } while (lineFromFile != null);

        } catch (IOException e) {
            e.printStackTrace();
        }
        creatorDirAndFile.writeToFile(list);
    }
}
