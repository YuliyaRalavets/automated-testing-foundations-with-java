package IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class MainTask {
    public static void main(String[] args) {

       MainTask mainTask = new MainTask();
        try {
            printTree(Paths.get("D:/YULIYA/aircompany"), "");
            //printTree(Paths.get("D:/!!! ВИДЕООПЕРАТОР !!!/DOC/калыханка"), "");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printTree(Path path, String mask) throws IOException {
       // try(Writer writer = new BufferedWriter(Files.newBufferedWriter()))
        System.out.println(path.getFileName());
        if (path.toFile().isDirectory()) {
            List<Path> paths = Files.list(path)
                    .sorted(Comparator.comparing((Path p) -> p.toFile().isDirectory()).thenComparing(Path::getFileName))
                    .collect(Collectors.toList());
            List<Path> dirs = paths.stream().filter(p-> p.toFile().isDirectory()).collect(Collectors.toList());
            for (int i = 0; i < paths.size(); i++) {
                if (paths.get(i).toFile().isFile()) {
                    System.out.printf("%s%s ", mask, dirs.size() == 0 ? " " : "\u2502 ");
                    printTree(paths.get(i), mask);
                } else {
                    System.out.printf("%s%s\u2500\u2500\u2500", mask, i == paths.size() - 1 ? "\u2514" : "\u251c");
                    printTree(paths.get(i), String.format("%s%s", mask, i == paths.size() - 1 ? "   " : "\u2502   "));
                }
            }
        }
    }

    private static void infoAboutFile(Path path){
        long filesCount = 0;
        long dirsCount = 0;
        double length = 0;
        Path parent = path.getParent();
        int d = path.getNameCount();
        textInfo(parent,filesCount,dirsCount,length,d);
    }

    private static void textInfo (Path path, long files, long dirs, double len, int count){
        long filesCount = files;
        long dirsCount = dirs;
        Path root = path.getRoot();
        //System.out.println();
        //System.out.println(path);
        if (root.equals(path)) {
            filesCount += countOfFilesInPath(path);
            dirsCount += contOfDirInPath(path);
            //System.out.println(countOfFilesInPath(path) + " files");
            //System.out.println(contOfDirInPath(path)+ " dirs");
            //System.out.println("len " + lengthOfFileName(path));
            len += lengthOfFileName(path);
            System.out.println("Total Dir "  + dirsCount);
            System.out.println("Total Files " + filesCount);
            //System.out.println("Total file name length is "+ len);
            System.out.printf("Average length is %.2f", (double)len/filesCount);
            System.out.printf("\nAverage number of files per folder is %.2f", (double)filesCount/count );

        }else {
            filesCount += countOfFilesInPath(path);
            dirsCount += contOfDirInPath(path);
            //System.out.println(countOfFilesInPath(path) + " files");
            //System.out.println(contOfDirInPath(path)+ " dirs");
            //System.out.println(lengthOfFileName(path));
            len += lengthOfFileName(path);
            textInfo(path.getParent(),filesCount,dirsCount,len,count);
        }
    }

    private static long contOfDirInPath(Path path) {
        List<File> files = Arrays.stream((path.toFile().listFiles())).collect(Collectors.toList());
        return files.stream().filter(File::isDirectory).count();
    }

    private static long countOfFilesInPath(Path path) {
        List<File> files = Arrays.stream((path.toFile().listFiles())).collect(Collectors.toList());
        return files.stream().filter(File::isFile).count();
    }

    private static double lengthOfFileName(Path path){
        int length = 0;
        List<File> files = Arrays.stream((path.toFile().listFiles())).collect(Collectors.toList()).stream().filter(File::isFile).collect(Collectors.toList());
        for(File f: files){
            length += f.getName().length();
        }
        return length;
    }
}



