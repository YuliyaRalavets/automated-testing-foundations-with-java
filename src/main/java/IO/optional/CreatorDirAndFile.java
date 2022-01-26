package IO.optional;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CreatorDirAndFile {
    private String dirName;
    private String fileName;

    public CreatorDirAndFile(String dirName, String fileName) {
        this.dirName = dirName;
        this.fileName = fileName;
        createDirToWrite(dirName);
        //createFileToWrite(fileName);

    }

    private void createDirToWrite(String dirName){
        try {
            if (Files.exists(Paths.get(dirName)))
                System.out.println("ужо есць");
            else Files.createDirectory(Paths.get(dirName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createFileToWrite(String fileName){
        //Path file = Paths.get(dirName + File.separator + fileName);
        try {
            if (Files.exists(fileForWritePath()))
            System.out.println("ужо есць");
            else Files.createFile(fileForWritePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Path fileForWritePath(){
        return Paths.get(dirName + File.separator + fileName);
    }
}
