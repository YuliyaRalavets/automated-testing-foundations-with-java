package IO.optional.taskone;

import IO.optional.CreatorDirAndFile;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TaskOne {
    public static void main(String[] args) {
        String dirName = "Task one";
        CreatorDirAndFile creatorDirAndFile = new CreatorDirAndFile(dirName);
        List<String> listOfRandomNums = new Random().ints().limit(20).boxed().sorted().map(String::valueOf).collect(Collectors.toList());
        creatorDirAndFile.writeToFile(listOfRandomNums);
    }
}