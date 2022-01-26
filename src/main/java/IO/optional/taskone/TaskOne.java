package IO.optional.taskone;

import IO.optional.CreatorDirAndFile;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TaskOne {
    public static void main(String[] args) {
        String dirName = "Task one";
        String fileName = "file.txt";
        /*Path file;
        file = Paths.get(dirName + File.separator + fileName);
        try {
            if (Files.exists(Paths.get(dirName)))
                System.out.println("ужо есць");
            else Files.createDirectory(Paths.get(dirName));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        List<String> listOfRandomNums = new Random().ints().limit(20).boxed().sorted().map(String::valueOf).collect(Collectors.toList());
        CreatorDirAndFile creatorDirAndFile = new CreatorDirAndFile(dirName,fileName);
        writeToFile(creatorDirAndFile.fileForWritePath(),listOfRandomNums);
        //createAndWrite(file,listOfRandomNums);
        /*Charset charset = Charset.forName("UTF-8");
        try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
            for (String num : listOfRandomNums) {
                writer.write(num);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    /*public static void createAndWrite(Path file, List<String> list){
        Charset charset = Charset.forName("UTF-8");
        try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
            for (String num : list) {
                writer.write(num);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public static void writeToFile(Path file, List<String> list){
        Charset charset = Charset.forName("UTF-8");
        try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
            for (String num : list) {
                writer.write(num);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}