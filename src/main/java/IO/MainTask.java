package IO;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainTask {
    public static void main(String[] args) {
        /*File dir1 = new File("D://YULIYA");
        File file1 = new File("D://YULIYA", "Hello.txt");
        File file2 = new File(dir1, "Hello2.txt");
        if(dir1.isDirectory())
        {
            // получаем все вложенные объекты в каталоге
            for(File item : dir1.listFiles()){

                if(item.isDirectory()){

                    System.out.println(item.getName() + "  \t folder");
                }
                else{

                    System.out.println(item.getName() + "\t file");
                }
            }
        }

        System.out.println("++++++++++++++++++++++++++++++++++");

        File dir = new File("D://YULIYA//NewDir");
        boolean created = dir.mkdir();
        if(created)
            System.out.println("Folder has been created");
        // переименуем каталог
        File newDir = new File("D://YULIYA//NewDirRenamed");
        dir.renameTo(newDir);
        // удалим каталог
        boolean deleted = newDir.delete();
        if(deleted)
            System.out.println("Folder has been deleted");*/

        File file = new File("D:/YULIYA/aircompany");
        Path path = file.toPath();
        if (Files.exists(path) && Files.isDirectory(path)) {
            int maxDepth = 2;
            try (Stream<Path> streamDir = Files.find(path, maxDepth,
                    (p, a) -> String.valueOf(p).endsWith(".java"))) {
                long counter = streamDir
                        .map(String::valueOf)
                        .peek(System.out::println)
                        .count();
                System.out.println("found: " + counter);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
       /* DirTree dir = new DirTree(path);
        dir.showTree();*/



        int maxDepth = 2;
        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    System.out.println("Start      "  + dir.toFile().getName());
                    System.out.println("|--" + dir.toFile().getName());
                    return FileVisitResult.CONTINUE;
                }
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    System.out.println("     " + file.toFile().getName());
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    System.out.println("fin+++++++++++++++++++++++++++++     "  + dir.toFile().getName());
                    return FileVisitResult.CONTINUE;
                }
            });
            DirectoryStream.Filter<Path> dirOnly = p -> {  // Functional Interface : boolean accept​(T entry)
                return Files.isDirectory(p);
            };


        } catch (IOException e) {
            e.printStackTrace();
        }

       /* File file = new File("D://YULIYA");
        if (file.exists() && file.isFile()) {
            System.out.println("Path " + file.getPath());
            System.out.println("Absolute Path " + file.getAbsolutePath());
            System.out.println("Size " + file.length());
            System.out.println("Dir " + file.getParent());
            file.delete();
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        File dir = new File("D:/YULIYA");
        if (dir.exists() && dir.isDirectory()) {
            for (File current : dir.listFiles()) {
                System.out.println(current.getName());
                long millis = current.lastModified();
                Instant date = Instant.ofEpochMilli(millis);
                //System.out.println(current.getPath());
            }
            File root = File.listRoots()[0];
            System.out.printf("\n%s %,d from %,d free bytes", root.getPath(), root.getUsableSpace(),
                    root.getTotalSpace());
        }*/
        }
    }



