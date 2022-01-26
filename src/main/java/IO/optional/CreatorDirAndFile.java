package IO.optional;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CreatorDirAndFile {
    private String dirName;

    public CreatorDirAndFile(String dirName) {
        this.dirName = dirName;
        createDirAndFileForWrite(dirName);
    }

    private void createDirAndFileForWrite(String dirName){
        try {
            if (Files.exists(Paths.get(dirName)))
                System.out.println("Directory with this name is already exist.");
            else {
                Files.createDirectory(Paths.get(dirName));
                Files.createFile(fileForWritePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Path fileForWritePath(){
        String fileName = "file.txt";
        return Paths.get(dirName + File.separator + fileName);
    }

    public void writeToFile(List<String> list){
        Charset charset = Charset.forName("UTF-8");
        try (BufferedWriter writer = Files.newBufferedWriter(fileForWritePath(), charset)) {
            for (String num : list) {
                writer.write(num);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
